<template>
  <div class="homeConainer">
    <el-container style>
      <el-header style="height:45px;" class="homeHeader">
        <blog-header @ShowMenuListInfo="ShowMenuList"></blog-header>
      </el-header>
      <el-container class="containerHeigth">
        <el-row type="flex" class="asideConainer">
          <el-col
            :md="4"
            :lg="3"
            :xl="3"
            :style="{width:isCollapse?'64px':''}"
            class="hidden-sm-and-down aside-left"
          >
            <el-aside class="homeAside" style="width:auto;overflow: hidden;">
              <blog-aside :isCollapse="isCollapse"></blog-aside>
            </el-aside>
          </el-col>
          <el-col
            :xs="24"
            :sm="24"
            :md="isCollapse?24:20"
            :lg="isCollapse?24:21"
            :xl="isCollapse?24:21"
          >
            <el-main class="homeMain">
              <router-view></router-view>
              <!-- <blog-main></blog-main> -->
            </el-main>
          </el-col>
        </el-row>
      </el-container>
      <template>
        <el-backtop>
          <i class="el-icon-caret-top"></i>
        </el-backtop>
      </template>
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
.homeConainer {
  //width: 100%;
}

.homeHeader {
  padding: 0;
  background-color: white;
}

.homeAside {
  background-color: #263238;
}

.homeMain {
  background-color: #ecf0f5;
  padding-bottom: 0px;
}
.asideConainer {
  width: 100%;
}
.aside-left {
  background-color: #263238;
  height: 700px;
}
.containerHeigth {
  min-height: 662px;
}
</style>
