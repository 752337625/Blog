<template>
  <div class="homeContent">
    <el-container>
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
    </el-container>
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
    //blogMain
  },
  methods: {
    ShowMenuList(visible) {
      console.log(visible);
      this.isCollapse = visible;
    }
  }
};
</script>

<style lang="less" scoped>

.homeContent,
.el-container,
.hidden-sm-and-down {
  height: 100%;
}
.el-row {
  width: 100%;
}
.rowPosition {
  overflow: hidden;
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
.el-header {
  padding: 0;
  background-color: #fff;
}
.iconfont,
p {
  font-size: 30px;
  display: block;
}

.blogger {
  height: 45px;
  padding-left: 20px;
}

.hidden-sm-and-down {
  background-color: rgb(38, 50, 56);
  background-color: #263238;
  float: left;

  height: 100%;
}
.headerPosition {
  float: right;

  height: 100%;
}
.el-main {
      height: 100%;
}
</style>