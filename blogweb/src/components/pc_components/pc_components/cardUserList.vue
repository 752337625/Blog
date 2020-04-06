<template>
  <div class="cardClass">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="用户名">
        <el-input v-model="formInline.user" placeholder="审批人"></el-input>
      </el-form-item>
      <el-form-item label="用户活跃状态">
        <el-select v-model="formInline.region" placeholder="活跃状态">
          <el-option label="新增" value="new"></el-option>
          <el-option label="活跃" value="active"></el-option>
          <el-option label="沉默" value="silence"></el-option>
          <el-option label="回流" value="backflow"></el-option>
          <el-option label="流失" value="loss"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
        <el-button type="primary" @click="onSubmit">导出</el-button>
        <el-button type="primary" @click="onSubmit">批量删除</el-button>
      </el-form-item>
    </el-form>
    <blogtable :tableInfo="tableInfo"></blogtable>
    <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
  </div>
</template>
<script>
import blogtable from "./blogtable";
export default {
  props:['tableInfo'],
  data: function() {
    return {
      formInline: {
        user: "",
        region: ""
      },
      
    };
  },
  components: {
    blogtable
  },
  methods: {
    onSubmit() {
      //console.log("submit!");
    }
  }
};
</script>

<style lang="less" scoped>
</style>
