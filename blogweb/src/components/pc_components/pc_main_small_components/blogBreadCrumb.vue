<template>
  <div class="">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/odometer' }">{{BreadCrumbInfo.Home}}</el-breadcrumb-item>
      <el-breadcrumb-item v-if="BreadCrumbInfo.LevelOneMenu">{{BreadCrumbInfo.LevelOneMenu}}</el-breadcrumb-item>
      <el-breadcrumb-item v-if="BreadCrumbInfo.LevelOneMenu">{{BreadCrumbInfo.LevelTwoMenu}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  props:['BreadCrumbInfo'],
  data: function() {
    return {};
  },
  components: {},
  methods: {}
};
</script>

<style lang="less" scoped>
.el-breadcrumb {
  margin-bottom: 10px;
}
</style>
