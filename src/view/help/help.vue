<!--  -->
<template>
    <Card :bordered="false">
        <p slot="title">
            使用帮助
        </p>
        <div class="cont">
            <h2>扫码关注“备案技术服务”公众号：</h2>
            <img :src="zhcode" width="300">
            <h3>技术联系人： 张 和</h3>
            <h3>技术支持电话：13146594125</h3>
            <h3>技术支持邮箱：elrecord@hitworth.com</h3>
            <h3>工作时间：周一至周五 &nbsp;&nbsp;上午:9点---12点 &nbsp; &nbsp;&nbsp;下午:1点---5点</h3>
        </div>
    </Card>
</template>

<script>
import zhcode from '@/assets/images/zhcode.png'
export default {
  data () {
    return {
        zhcode
    };
  },
}

</script>
<style scoped>
</style>
