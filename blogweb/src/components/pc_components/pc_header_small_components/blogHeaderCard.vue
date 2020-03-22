<template>
<div :class="['headerCardConainer']" :style="{top:client.clientY,left:client.clientX}">
    <el-card class="box-card">
        {{info.name}}
        <!-- <div v-for="o in 4" :key="o" class="text item">
            {{'列表内容 ' + o }}
        </div> -->
    </el-card>
</div>
</template>

<script>
export default {
     props: ['info','client'],
    data: function () {
        return {

        }

    },
    components: {

    },
    methods: {

    },
};
</script>

<style lang="less" scoped>
.headerCardConainer{
    z-index: 3000;
    position: absolute;
}
 .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    //width: 480px;
    width:auto
  }
</style>
