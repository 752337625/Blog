<template>
<div class="mainConainer">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/Main' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>文章管理</el-breadcrumb-item>
    <el-breadcrumb-item>新增文章</el-breadcrumb-item>
  </el-breadcrumb>
  <el-card class="box-card">
    <quill-editor v-model="content" />
  </el-card>
</div>
</template>

<script>
export default {
  data: function () {
    return {

      content: ''
    }

  },
  components: {

  },
  methods: {

  },
};
</script>

<style lang="less" scoped>
.mainConainer{
     // min-height: 800px;
}
.el-breadcrumb{
  margin-bottom: 10px;
}
// .box-card {
//   margin-top: 10px;
//   min-height: 775.6px;
// }
// .el-card__body {
//     min-height: 735.6px;
// }
// .quill-edito {
//   min-height: 700px;

// }
// .ql-container{
//   min-height: 500px;
// }
</style>
