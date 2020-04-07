<template>
  <div class="homeContent">
    <el-container>
      <el-header>
        <el-row type="flex">
          <el-col>
            <router-link to="/Home">后台管理系统</router-link>
          </el-col>
          <el-col>
            <blog-header @ShowMenuListInfo="ShowMenuList"></blog-header>
          </el-col>
        </el-row>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <blog-aside :isCollapse="isCollapse"></blog-aside>
        </el-aside>
        <router-view></router-view>
      </el-container>
    </el-container>

    <!-- <el-container>
      <el-row type="flex" class="rowPosition">
        <el-col :md="4" :lg="3" :xl="3" class="hidden-sm-and-down">
          <el-row type="flex" class="blogger" align="middle">
            <div>
              <i class="iconfont iconblogger"></i>
            </div>
            <div>
              <p>Blog</p>
            </div>
          </el-row>
          <blog-aside :isCollapse="isCollapse"></blog-aside>
        </el-col>
        <el-col :xs="24" :sm="24" :md="20" :lg="21" :xl="21" class="headerPosition">
          <el-header style="height:45px;" class="header">
            <blog-header @ShowMenuListInfo="ShowMenuList"></blog-header>
          </el-header>
          <el-main>
           <router-view></router-view>
          </el-main>
        </el-col>
      </el-row>
    </el-container>-->
  </div>
</template>

<script>
import blogHeader from "../components/pc_components/blogHeader";
import blogAside from "../components/pc_components/blogAside";
export default {
  data: function() {
    return {
      isCollapse: false
    };
  },
  components: {
    blogHeader,
    blogAside
  },
  methods: {
    ShowMenuListInfo() {}
  }
};
</script>

<style lang="less" scoped>
.homeContent {
 
  .el-aside{
      overflow: hidden;
      min-height: 700px;
       height: 700px;
      max-height: 800px;
    }
  .el-header {
    padding: 0;
    background-color: #001529;
    height: 45px !important;
    border-bottom: 2px solid #2fb9d4;
    .el-row {
      width: 100%;
      height: 100%;
    }
    
    .el-row > div {
      height: 100%;
      &:first-child {
        width: 200px;
        min-width: 200px;
        border-right: 1px solid #2fb9d4;
        text-align: center;
        line-height: 45px;
      }
      &:last-child {
        min-width: 568px;
      }
    }
  }
}
</style>