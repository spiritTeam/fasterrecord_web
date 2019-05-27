import env from './env'

const DEV_URL = 'localhost'
const PRO_URL = '../'
//http://workorder.energylabelrecord.com

export default env === 'development' ? DEV_URL : PRO_URL
