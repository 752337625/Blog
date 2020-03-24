<template>
<div class="">
  <el-table :data="columnData" style="width: 100%" stripe border highlight-current-row height="450">
    <el-table-column  v-for="(column,index) in columnInfo" :key="index" :prop=column.prop  :label=column.label  :width=column.width></el-table-column>
    <!-- <el-table-column prop="blog" label="标题"></el-table-column>
    <el-table-column prop="desc" label="描述"></el-table-column>
    <el-table-column prop="createTime" label="创建时间" width="100"></el-table-column>
    <el-table-column prop="updateTime" label="更新时间" width="100"></el-table-column> -->
    <!-- <el-table-column label="操作" width="250">
      <template slot-scope="scope">
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column> -->
  </el-table>
</div>
</template>

<script>
export default {
  props:['columnInfo','columnData'],
  data: function () {
    return {
     
    };
  },
  components: {},
  methods: {}
};
</script>

<style lang="less" scoped>
</style>
