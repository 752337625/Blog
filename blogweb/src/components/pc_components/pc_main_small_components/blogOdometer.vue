<template>
  <div class="mainConainer">
    <div></div>
    <!-- <BlogBreadCrumb :BreadCrumbInfo="BreadCrumbInfo"></BlogBreadCrumb> -->
    <el-row class="row-margin">
      <el-card class>
        <div>
          <strong>常用</strong>
          <el-divider></el-divider>
        </div>
      </el-card>
    </el-row>
    <el-row class="row-margin">
      <el-card class>
        <div>
          <strong>概览</strong>
          <el-divider></el-divider>
        </div>
      </el-card>
    </el-row>
    <el-row type="flex" justify="flex-between" class="row-margin">
      <el-card class style="flex:0.5">
        <div>
          <strong>资源</strong>
          <el-divider></el-divider>
        </div>
      </el-card>
      <el-card class style="flex:0.5">
        <div>
          <strong>SLA告警</strong>
          <el-divider></el-divider>
        </div>
      </el-card>
    </el-row>
    <el-row type="flex" justify="flex-between">
      <el-row style="flex:0.5">
        <el-card class >
          <div>
            <strong>服务</strong>
            <el-divider></el-divider>
          </div>
        </el-card>
        <el-card class >
          <div>
            <strong>高级账户</strong>
            <el-divider></el-divider>
          </div>
        </el-card>
      </el-row>
      <el-row style="flex:0.5">
        <el-card class style="height: 10000px;">
          <div>
            <strong>最近运维</strong>
            <el-divider></el-divider>
          </div>
        </el-card>
        <el-card class style="flex:0.5">
          <div>
            <strong>开发者新闻</strong>
            <el-divider></el-divider>
          </div>
        </el-card>
      </el-row>
    </el-row>
  </div>
</template>

<script>
//import BlogBreadCrumb from "./blogBreadCrumb";
export default {
  data: function() {
    return {
      BreadCrumbInfo: {
        Home: "首页"
      }
    };
  },
  components: {
    //BlogBreadCrumb
  },
  methods: {}
};
</script>

<style lang="less" scoped>
.el-divider {
  margin: 0 0 10px 0;
}
.row-margin {
  margin-bottom: 10px;
}
strong {
  font-size: 14px;
}
</style>
