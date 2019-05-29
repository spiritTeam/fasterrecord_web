package com.hitworth.framework.base.controller;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.hitworth.framework.base.vo.NewTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.model.Function;
import com.hitworth.framework.base.service.FunctionService;
import com.hitworth.framework.base.util.BusinessException;
import com.hitworth.framework.base.util.PageUtil;
import com.hitworth.framework.base.util.ResponseUtil;
import com.hitworth.framework.base.util.UserUtil;
import com.hitworth.framework.base.vo.FunctionTree;
import com.hitworth.framework.base.vo.Menus;


/**
 * function action
 * 
 * 项目名称：base_spring_framework 类名称：FunctionController 类描述： function action 创建人：huangxiong
 * 创建时间：2015年2月6日 下午1:59:41 修改人：huangxiong 修改时间：2015年2月6日 下午1:59:41 修改备注：
 * 
 * @version
 * 
 */
@Controller
@RequestMapping("/function")
public class FunctionController {

  @Autowired
  FunctionService functionService;


  /**
   * 新增功能
   * 
   * @Title: add @Description: 新增功能 @param @param function 对象 @param @return @return Object
   *         返回类型 @throws
   */
  @RequestMapping(value = "/add")
  public @ResponseBody Object add(Function function) {
    functionService.insertFunction(function);
    return ResponseUtil.success();
  }

  /**
   * 删除function
   * 
   * @Title: delete @Description: 删除function @param @param id functionId @param @return @return
   *         Object 返回类型 @throws
   */
  @RequestMapping(value = "/delete")
  public @ResponseBody Object delete(@RequestParam(value = "id") int id) {
    functionService.deleteFunction(id);
    return ResponseUtil.success();
  }



  @RequestMapping(value = "/frozen", method = RequestMethod.POST)
  public @ResponseBody Object frozen(@RequestParam("id") int id, @RequestParam("state") int state) {
    functionService.updateState(id, state);
    return ResponseUtil.success();
  }


  /**
   * 修改function
   * 
   * @Title: update @Description: 修改function @param @param function @param @return @return Object
   *         返回类型 @throws
   */
  @RequestMapping(value = "/update")
  public @ResponseBody Object update(Function function) {

    functionService.updateFunction(function);
    return ResponseUtil.success();
  }



  /**
   * 
   * @Title: checkFunctions @Description: 更新function选择树 @param @param roleId 角色ID @param @param
   *         functionIds 功能id集合 @return Object 返回类型 @throws
   */
  @RequestMapping("/checkFunctions")
  public @ResponseBody Object checkFunctions(@RequestParam(value = "roleId") int roleId,
      @RequestParam(value = "functionIds") String functionIds) {
    functionService.updateFunctionschecked(roleId, functionIds);
    return ResponseUtil.success();
  }


  @RequestMapping("/rootList")
  public @ResponseBody Object checkFunctions(
      @RequestParam(value = "id", required = false) String id) {
    List<FunctionTree> functionList = functionService.findRootList(id);
    return functionList;


  }

  /**
   * 
   * @Title: mylist @Description: 获取当前用户的功能列表 @return Object 返回类型 @throws
   */
  @RequestMapping("/mylist")
  public @ResponseBody Object mylist() {
    String loginName = UserUtil.getLoginName();
    List<Function> functionList =
        functionService.findAllEffectiveFunctionsbyLoginName(loginName);
    Map<Integer, Menus> menusMap = initMenusList(functionList);

    return menusMap.values();
  }

  /**
   * 初始化功能列表<br/>
   * 支持VUE<br/>
   * 
   * @param functionList
   * @return
   */
  private Map<Integer, Menus> initMenusList(List<Function> functionList) {
    Map<Integer, Menus> menusMap = new TreeMap<Integer, Menus>();
    for (Function function : functionList) {
      Menus menus = new Menus(function);

      if (function.getParentId() == 0) {
        menusMap.put(function.getId(), menus);
      } else {
        Menus parentMenus = menusMap.get(function.getParentId());
        parentMenus.getChildren().add(menus);
      }
    }
    return menusMap;
  }

  /**
   * 
   * @Title: list @Description: 所有功能列表 @param @param pageNum 当前页 @param @param pageSize 每页数量 @return
   *         Object 返回类型 @throws
   */
  @RequestMapping("/list")
  public @ResponseBody Object list(Function function,
      @RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
      @RequestParam(defaultValue = "15", value = "pageSize") int pageSize) {

    PageInfo<Function> page = functionService.findFunctionList(function, pageNum, pageSize);
    return PageUtil.convertGrid(page);
  }

  /**
   * 
   * @Title: function tree @Description: 所有功能列表 @param roleId 角色ID @return Object 返回类型 @throws
   */
  @RequestMapping("/functionTree")
  public @ResponseBody Object functionTree(
      @RequestParam(defaultValue = "1", value = "roleId") int roleId) {

    List<FunctionTree> list = functionService.findFunctionTree(roleId);
    return list;
  }

  /**
   *
   * @Title: function tree @Description: 所有功能列表 @param roleId 角色ID @return Object 返回类型 @throws
   */
  @RequestMapping("/functionTree2")
  public @ResponseBody Object functionTree2(
      @RequestParam(defaultValue = "1", value = "roleId") int roleId) {

    List<NewTree> list = functionService.findFunctionTree2(roleId);

    return list;
  }

  /**
   * 异常处理
   * 
   * @Title: exception @Description: 异常处理 @param @param e @param @return @return Object 返回类型 @throws
   */
  @ExceptionHandler({BusinessException.class})
  public @ResponseBody Object exception(BusinessException e) {
    return ResponseUtil.fail(e.getErr());
  }

}
