package com.hitworth.framework.base.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hitworth.framework.base.vo.NewTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.dao.FunctionDAO;
import com.hitworth.framework.base.model.Function;
import com.hitworth.framework.base.service.FunctionService;
import com.hitworth.framework.base.util.BusinessException;
import com.hitworth.framework.base.util.ConstantUtil;
import com.hitworth.framework.base.vo.FunctionTree;


/**
 * function serviceImpl
 * 
 * 项目名称：base_spring_framework 类名称：FunctionServiceImpl 类描述： 创建人：huangx 创建时间：2015年1月27日 下午7:17:30
 * 修改人：huangx 修改时间：2015年1月27日 下午7:17:30 修改备注：
 * 
 * @version
 * 
 */
@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

  @Autowired
  private FunctionDAO functionDAO;



  @Override
  public void insertFunction(Function function) {
    validate(function);
    if (findFunctionbyParentIdAndFunctionName(function).size() > 0)
      throw new BusinessException(10122);
    init(function);
    functionDAO.insertFunction(function);

  }

  @Override
  public void deleteFunction(int id) {

    // 存在孩子，不能删除
    List<Function> list = functionDAO.findFunctionbyParentId(id);
    if (list.size() > 0) throw new BusinessException(10119);
    // 删除关联表
    functionDAO.deleteFunctionRole(id);
    // 删除功能表
    functionDAO.deleteFunction(id);

  }

  @Override
  public void updateFunction(Function function) {

    validate(function);
    functionDAO.updateFunction(function);

  }

  @Override
  public void updateFunctionschecked(int roleId, String functionIds) {
    // 删除旧关系
    functionDAO.deleteRoleFunction(roleId);
    // 建立新关系
    if (!"".equals(functionIds)) {
      String[] ids = functionIds.split(",");
      for (String functionId : ids) {
        if (Integer.valueOf(functionId).equals(0)) continue;
        functionDAO.insertFunctionRole(Integer.valueOf(functionId), roleId);
      }

    }
  }

  @Override
  public void updateState(int id, int state) {

    state = state == ConstantUtil.OK ? ConstantUtil.FAIL : ConstantUtil.OK;

    functionDAO.updateState(id, state);

  }


  @Override
  public List<Function> findAllEffectiveFunctionsbyLoginName(String loginName) {
    return functionDAO.findAllEffectiveFunctionsbyLoginName(loginName);
  }

  @Override
  public List<Function> findAllEffectiveFunctionsbyRoleId(Integer roleId) {
    return functionDAO.findAllEffectiveFunctionsbyRoleId(roleId);
  }

  @Override
  public PageInfo<Function> findFunctionList(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Function> list = functionDAO.findFunctionList();
    PageInfo<Function> page = new PageInfo<Function>(list);
    return page;
  }

  @Override
  public PageInfo<Function> findFunctionList(Function function, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Function> list = functionDAO.findFunctionListByQuery(function);
    PageInfo<Function> page = new PageInfo<Function>(list);
    return page;
  }


  @Override
  public List<Integer> findEffectiveFunctionsbyAction(String action) {
    return functionDAO.findEffectiveFunctionsbyAction(action);
  }

  @Override
  public List<FunctionTree> findFunctionTree(int roleId) {

    List<FunctionTree> functionTreeList = new ArrayList<FunctionTree>();
    List<Function> effectiveFunctinList = functionDAO.findEffectiveFunctinList();
    List<Integer> checkedFunctionlist = functionDAO.findFunctionTree(roleId);

    for (Function func : effectiveFunctinList) {
      FunctionTree funcTree = new FunctionTree();
      funcTree.setId(func.getId());
      funcTree.setpId(func.getParentId());
      funcTree.setName(func.getTitle());
      funcTree.setIcon(func.getIcon());
      for (Integer checkedFunctionId : checkedFunctionlist) {
        if (Integer.valueOf(func.getId()).equals(checkedFunctionId)) funcTree.setChecked(true);
      }
      functionTreeList.add(funcTree);
    }


    return functionTreeList;
  }

  @Override
  public List<NewTree> findFunctionTree2(int roleId) {

    List<Function> effectiveFunctinList = functionDAO.findFunctionbyParentId(0);
    List<Integer> checkedFunctionlist = functionDAO.findFunctionTree(roleId);

    List<NewTree> functionTreeList = new ArrayList<NewTree>();
    for (Function func : effectiveFunctinList) {
      NewTree funcTree = new NewTree();
      funcTree.setId(func.getId());
      funcTree.setTitle(func.getTitle());
      for (Integer checkedFunctionId : checkedFunctionlist) {
        if (Integer.valueOf(func.getId()).equals(checkedFunctionId)) funcTree.setChecked(true);
      }

      //第二层
      List<Function> childrenFunctinList = functionDAO.findFunctionbyParentId(func.getId());
      if(null!=childrenFunctinList && childrenFunctinList.size()>0){
        List<NewTree> functionTreeList2 = new ArrayList<NewTree>();
        for(Function func2 : childrenFunctinList){
          NewTree funcTree2 = new NewTree();
          funcTree2.setId(func2.getId());
          funcTree2.setTitle(func2.getTitle());
          for (Integer checkedFunctionId : checkedFunctionlist) {
            if (Integer.valueOf(func2.getId()).equals(checkedFunctionId)) funcTree2.setChecked(true);
          }

          //第三层
          List<Function> childrenFunctinList2 = functionDAO.findFunctionbyParentId(func2.getId());
          if(null!=childrenFunctinList2 && childrenFunctinList2.size()>0){
            List<NewTree> functionTreeList3 = new ArrayList<NewTree>();
            for(Function func3 : childrenFunctinList2){
              NewTree funcTree3 = new NewTree();
              funcTree3.setId(func3.getId());
              funcTree3.setTitle(func3.getTitle());
              for (Integer checkedFunctionId : checkedFunctionlist) {
                if (Integer.valueOf(func3.getId()).equals(checkedFunctionId)) funcTree3.setChecked(true);
              }
              functionTreeList3.add(funcTree3);
            }
            funcTree2.setChildren(functionTreeList3);
          }
          functionTreeList2.add(funcTree2);
        }
        funcTree.setChildren(functionTreeList2);
      }
      functionTreeList.add(funcTree);
    }


    return functionTreeList;
  }

  /**
   * 参数检查
   * 
   * @Title: validate
   * @Description: 参数检查
   * @param @param function
   * @return void 返回类型
   * @throws
   */
  private void validate(Function function) {

    if (StringUtils.isEmpty(function.getTitle())) throw new BusinessException(10113);
    if (function.getTitle().length() > 50) throw new BusinessException(10114);
//    if (StringUtils.isEmpty(function.getAction())) throw new BusinessException(10116);
//    if (function.getAction().length() > 255) throw new BusinessException(10117);
    if (StringUtils.isEmpty(function.getState())) throw new BusinessException(10118);
    Pattern p = Pattern.compile("^/.*|#");
//    Matcher m = p.matcher(function.getAction());
//    if (!m.matches()) throw new BusinessException(10120);
//    
//    if(ConstantUtil.OK!=function.getState()&&ConstantUtil.FAIL!=function.getState())
//      throw new BusinessException(10125);
//    
//    if(ConstantUtil.OK!=function.getDisplay()&&ConstantUtil.FAIL!=function.getDisplay())
//      throw new BusinessException(10126);
  }

  /**
   * 对象初始化
   * 
   * @Title: init
   * @Description: 对象初始化
   * @param @param function
   * @return void 返回类型
   * @throws
   */
  private void init(Function function) {
    function.setInsertTime(new Timestamp(System.currentTimeMillis()));
    function.setIcon("fa fa-th-large");
  }

  @Override
  public List<FunctionTree> findRootList(String id) {

    List<FunctionTree> functionTreeList = new ArrayList<FunctionTree>();
    List<Function> allFunctionlist = functionDAO.findFunctionList();

    for (Function func : allFunctionlist) {
      FunctionTree funcTree = new FunctionTree();
      funcTree.setId(func.getId());
      funcTree.setpId(func.getParentId());
      funcTree.setName(func.getTitle());
      funcTree.setIcon(func.getIcon());
      if (!StringUtils.isEmpty(id)) {
        // 查询id的父ID
        Function function = functionDAO.findFunction(Integer.valueOf(id));
        if (func.getId() == function.getParentId()) funcTree.setChecked(true);
        if (func.getId() == function.getId()) continue;
      }
      functionTreeList.add(funcTree);
    }


    return functionTreeList;
  }

  @Override
  public List<Function> findFunctionbyParentIdAndFunctionName(Function function) {

    return functionDAO.findFunctionbyParentIdAndFunctionName(function);
  }



}
