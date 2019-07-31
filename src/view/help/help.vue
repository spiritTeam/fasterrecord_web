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
