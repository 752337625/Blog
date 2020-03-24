<template>
  <div class="mainConainer">
    <div></div>
    <!-- <BlogBreadCrumb :BreadCrumbInfo="BreadCrumbInfo"></BlogBreadCrumb> -->
    <el-card class="box-card ql-container ql-snow">
      <el-row type="flex" justify="space-between" align="middle" style="margin-bottom: 10px;">



        
      </el-row>
    </el-card>
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

</style>
