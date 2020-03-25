<template>
  <div class="homeContent">
    <el-container>
      <el-row type="flex">
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
          <el-main class="main">
            <!-- <router-view></router-view> -->
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
      this.isCollapse = visible;
    }
  }
};
</script>

<style lang="less" scoped>
// .hidden-sm-and-down {
//   position: fixed;
//   top: 0;
//   left: 0;
//   //height: 100%;
// }
// .headerPosition {
//   position: absolute;
//   right: 0;
//   top: 0;
// }
// .header {
//   position: fixed;
//   width: 100%;
//   background-color: #ffffff;
// }
.main {
}
.homeContent,
.el-container,
.hidden-sm-and-down {
  height: 100%;
}
.el-row {
  width: 100%;
}
.el-header {
  padding: 0;
}
.iconfont {
  font-size: 0.4rem;
}
.blogger {
  height: 0.8rem;
  padding-left: 20px;
}
.blogger div:first-child {
  padding: 10px;
}
.hidden-sm-and-down {
  background-color: rgb(38, 50, 56);
}
</style>