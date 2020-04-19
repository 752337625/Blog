<template>
  <div class="homeContent">
    <el-container>
      <el-header>
        <blog-header></blog-header>
      </el-header>
      <el-container class="container">
        <el-aside width="201px">
          <blog-aside></blog-aside>
        </el-aside>
        <el-main :style="{width:width}">
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import blogHeader from "../components/pc_components/blogHeader";
import blogAside from "../components/pc_components/blogAside";
export default {
  data: function() {
    return {
      width:'100%',
    };
  },
  components: {
    blogHeader,
    blogAside
  },
  mounted() {
    this.width=document.getElementsByClassName('el-main')[0].clientWidth-201+'px'
  },
  methods: {
    async logout() {
      const { data: res } = await this.$http.get("/logout");
      if (res.statue != 200) return this.$message.error(res.message);
      this.$router.push("/Login");
    }
  }
};
</script>

<style lang="less" scoped>
.homeContent {
  .el-header {
    height: 45px !important;
    background-color: #001529;
    padding: 0;
    border-bottom: 3px solid #2fb9d4;
  }
   .el-container{
     height: 100%;
     .el-aside {
    overflow: hidden;
    height: 100%;
     float: left;
  }
  .el-main{
    //width: 100%;
    float:right;
    height: 100%;
    padding: 10px 10px 10px 10px;
       // background: #fff;
  }

  }
  
}

</style>