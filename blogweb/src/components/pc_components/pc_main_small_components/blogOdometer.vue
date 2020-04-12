<template>
  <div class="mainConainer">
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
    <el-row class="row-margin">
      <el-col>
        <strong>资源</strong>
        <el-divider></el-divider>
      </el-col>
      <el-col>
        <strong>SLA告警</strong>
        <el-divider></el-divider>
      </el-col>
    </el-row>
    <el-row class="row-margin">
      <el-col>
        <strong>服务</strong>
        <el-divider></el-divider>
      </el-col>
      <el-col>
        <strong>高级账户</strong>
        <el-divider></el-divider>
      </el-col>
    </el-row>
    <el-row class="row-margin">
      <el-col>
        <strong>最近运维</strong>
        <el-divider></el-divider>
      </el-col>
      <el-col>
        <strong>开发者新闻</strong>
        <el-divider></el-divider>
      </el-col>
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
.childStyle(@l,@bc,@p,@w) {
  float: @l;
  background-color: @bc;
  padding: @p;
  width: @w;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  border-radius: 4px;
}
.mainConainer {
  width: 100%;
  // background: aqua;
  height: 100%;
  & > .el-row:first-child {
    .el-card {
      width: 100%;
    }
  }
  & > .el-row:nth-child(2) {
    .el-card {
      width: 100%;
    }
  }
  & > .el-row:nth-child(3) {
    & > div:first-child {
      .childStyle(@l:left, @bc:#ffffff, @p:20px, @w:49%) // float: left;
        // background-color: #ffffff;
        // padding: 20px;
        // width: 49%;;
    }
    & > div:last-child {
      .childStyle(@l:right, @bc:#ffffff, @p:20px, @w:50%);
    }
  }
  & > .el-row:nth-child(4) {
    & > div:first-child {
      .childStyle(@l:left, @bc:#ffffff, @p:20px, @w:49%);
    }
    & > div:last-child {
      .childStyle(@l:right, @bc:#ffffff, @p:20px, @w:50%);
    }
  }
  & > .el-row:nth-child(5) {
    & > div:first-child {
      .childStyle(@l:left, @bc:#ffffff, @p:20px, @w:49%);
    }
    & > div:last-child {
      .childStyle(@l:right, @bc:#ffffff, @p:20px, @w:50%);
    }
  }
}

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
