<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/odometer' }">{{breadcrumb.to}}</el-breadcrumb-item>
      <el-breadcrumb-item>{{breadcrumb.LevelOneto}}</el-breadcrumb-item>
      <el-breadcrumb-item>{{breadcrumb.LevelTwoto}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>
<script>
export default {
  props: ["breadcrumb"],
  data: function() {
    return {};
  },
  components: {},
  methods: {}
};
</script>

<style lang="less" scoped>
.el-breadcrumb {
  height: 40px;
  line-height: 40px;
  padding-left: 10px;
}
</style>
