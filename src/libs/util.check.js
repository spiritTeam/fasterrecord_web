/*数字校验类-私有*/
class NumberCheck {
  /** 是否数字 */
  isNumber(value){
    return /^[+-]?\d+(\.\d+)?$/.test(value);
  }
  /** 是否整数 */
  isInteger(value){
    return /^[0-9]\d*$/.test(value);
  }
  /** 是否有效整数，第一位不是0 */
  isValidInteger(value){
    return /^[1-9][0-9]*$/.test(value);
  }
  /** 整数或一位小数 */
  isIntegerOrOneDecimals(value){
    return /^[0-9]+([.]{1}[0-9]{1,1})?$/.test(value);
  }
  /** 是否1位小数 */
  isOneDecimal(value){
    return /^(([1-9]{1}\d*)|(0{1}))(\.\d{1})$/.test(value);
  }
  /** 是否2位小数 */
  isTwoDecimal(value){
    return /^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/.test(value);
  }
  /** 1位或2位小数 */
  isOneOrTwoDecimals(value){
    return /^[0-9]+[.]{1}[0-9]{1,2}?$/.test(value);
  }
  /** 是否3位小数 */
  isThreeDecimal(value){
    return /^(([1-9]{1}\d*)|(0{1}))(\.\d{3})$/.test(value);
  }
  /** 是否n位小数 */
  isFreeDecimals(value, num){
    let decimal=eval("/^(([1-9]{1}\d*)|(0{1}))(\.\d{"+num+"})$/");
    return decimal.test(value);
  }

  /** 至少一位小数 */
  atLeastOneDecimals(value){
    return /^[0-9]\+?(\d*\.\d{1,5})$/.test(value);
  }
  /** 至少两位小数 */
  atLeastTwoDecimals(value){
    return /^[0-9]\+?(\d*\.\d{2,5})$/.test(value);
  }
  /** 至少三位小数 */
  atLeastThreeDecimals(value){
    return /^[0-9]\+?(\d*\.\d{3,5})$/.test(value);
  }
  /** 至少四位小数 */
  atLeastFourDecimals(value){
    return /^[0-9]\+?(\d*\.\d{4,5})$/.test(value);
  }
  /** 至少n位小数 */
  atLeastFreeDecimals(value, num){
    let atLeast=eval("/^[0-9]\+?(\d*\.\d{"+num+",5})$/");
    return atLeast.test(value);
  }
  /** 两位有效数字 */
  isTwoDigits(value){
    return /^[1-9]\d{1}$|^[1-9]\.\d{1}$|^0\.0*[0-9]{2}$/.test(value);
  }
  /** 三位有效数字 */
  isThreeDigits(value){
    return /^[1-9]\.?\d{2}$|^[1-9]{2}\.\d{1}$|^0\.0*[0-9]{3}$/.test(value);
  }
}

/** 总检测类 */
class Check {
  constructor() {
    this.number=new NumberCheck();
  }
}
const _check=new Check();
export default _check;