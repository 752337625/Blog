<template>
  <div class="mainConainer">
    <div></div>
    <BlogBreadCrumb :BreadCrumbInfo="BreadCrumbInfo"></BlogBreadCrumb>
    <el-card class="box-card ql-container ql-snow">
      <el-row type="flex" justify="space-between" align="middle" style="margin-bottom: 10px;">
        <div>
         <h2>欢迎使用我的</h2>
        </div>
        <div>
          <el-button type="primary" size="small">保存草稿</el-button>
          <el-button type="primary" size="small">发布文章</el-button>
        </div>
      </el-row>
      <quill-editor v-model="content" :options="editorOption"></quill-editor>
    </el-card>
  </div>
</template>

<script>
import BlogBreadCrumb from "./blogBreadCrumb";
//悬浮显示富文本
import { addQuillTitle } from "../../../assets/js/quill-title.js";
export default {
  data: function() {
    return {
      content: "",
      editorOption: {},
      BreadCrumbInfo: {
        Home: "首页",
        LevelOneMenu: "文章管理",
        LevelTwoMenu: "新增文章"
      }
    };
  },
  mounted: function() {
    //悬浮显示title
    addQuillTitle();
  },
  components: {
    BlogBreadCrumb
  },
  methods: {}
};
</script>

<style lang="less" scoped>
.box-card {
  height: 627px;
}
.mainConainer {
  height: 100%;
}
</style>
