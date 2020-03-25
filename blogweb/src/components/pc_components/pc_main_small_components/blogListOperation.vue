<template>
  <div class="mainConainer">
    <BlogBreadCrumb :BreadCrumbInfo="BreadCrumbInfo"></BlogBreadCrumb>
    <el-card class="box-card">
      <el-row style="margin-bottom: 10px;" type="flex" justify="start" align="middle">
        <el-col :span="24">
          <el-form
            :label-position="labelPosition"
            label-width="80px"
            :model="formLabelAlign"
            inline
          >
            <el-form-item label="作者" label-width="auto">
              <el-input v-model="formLabelAlign.name" size="mini "  clearable></el-input>
            </el-form-item>
            <el-form-item label="标题"  label-width="auto">
              <el-input v-model="formLabelAlign.type"  clearable size="mini "></el-input>
            </el-form-item>
            <el-form-item label="创建时间" label-width="auto">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="formLabelAlign.region"
                size="mini "
              ></el-date-picker>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <el-row style="margin-bottom: 10px;">
        <el-col :span="24">
          <BlogTable :columnInfo="columnInfo" :columnData="columnData"></BlogTable>
        </el-col>
      </el-row>
      <el-row type="flex" justify="end" align="middle">
        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import BlogBreadCrumb from "./blogBreadCrumb";
import BlogTable from "./pc_small_components/blogTable";
export default {
  data: function() {
    return {
      labelPosition: "right",
      formLabelAlign: {
        name: "",
        region: "",
        type: ""
      },
      BreadCrumbInfo: {
        Home: "首页",
        LevelOneMenu: "文章管理",
        LevelTwoMenu: "文章列表"
      },
      columnInfo: [
        {
          prop: "name",
          label: "作者",
          width: "100"
        },
        {
          prop: "blog",
          label: "标题",
          width: ""
        },
        {
          prop: "desc",
          label: "描述",
          width: ""
        },
        {
          prop: "createTime",
          label: "创建时间",
          width: "100"
        },
        {
          prop: "updateTime",
          label: "更新时间",
          width: "100"
        }
      ],
      columnData: [
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        },
        {
          index: "100",
          name: "易烊千玺",
          blog: "我的第一个博客生涯就这没开始了,有没有有没有",
          desc:
            "感觉很尬易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺易烊千玺",
          createTime: "2016-05-02",
          updateTime: "2016-05-02"
        }
      ]
    };
  },
  components: {
    BlogBreadCrumb,
    BlogTable
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  }
};
</script>

<style lang="less" scoped>
.box-card {
  //min-height: 627px;
}
.el-form-item--mini.el-form-item {
  margin-bottom: 0px;
}
.el-form-item {
  margin-bottom: 0px;
}
.el-form.el-form--label-right.el-form--inline {
  display: flex;
  justify-content: start;
  align-items: center;
}
</style>
