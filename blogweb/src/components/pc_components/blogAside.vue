<template>
<div class="blogAsideConainer">
    <el-menu default-active="1" :collapse-transition="false" @open="handleOpen" @close="handleClose" :unique-opened="true" :collapse="isCollapse" background-color="#263238" text-color="#fff" active-text-color="#ffd04b" style="border: 0;">
        <el-menu-item index="1">
            <i class="el-icon-setting"></i>
            <span slot="title">仪表盘</span>
        </el-menu-item>
        <el-menu-item index="2">
            <i class="el-icon-location"></i>
            <span slot="title">系统管理</span>
            <!-- <el-menu-item-group>
                <template slot="title">分组一</template>
                <el-menu-item index="1-1">选项1</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu> -->
        </el-menu-item>
        <el-menu-item index="3">
            <i class="el-icon-document"></i>
            <span slot="title">广告管理</span>
        </el-menu-item>
         <el-submenu index="4">
            <template slot="title">
                <i class="el-icon-document"></i>
                <span>菜单管理</span>
            </template>
            <el-menu-item index="4-1-1">
                <template>
                    <i class="el-icon-document"></i>
                    <span>菜单设置</span>
                </template>
            </el-menu-item>
             <el-menu-item index="6-1-2">
                <template>
                    <i class="el-icon-document"></i>
                    <span>菜单授权</span>
                </template>
            </el-menu-item>
        </el-submenu>
        <el-menu-item index="5">
            <i class="el-icon-setting"></i>
            <span slot="title">留言管理</span>
        </el-menu-item>
        <el-submenu index="6">
            <template slot="title">
                <i class="el-icon-document"></i>
                <span>文章管理</span>
            </template>
            <el-menu-item index="6-1-1">
                <template>
                    <i class="el-icon-document"></i>
                    <span>新增文章</span>
                </template>
            </el-menu-item>
             <el-menu-item index="6-1-2">
                <template>
                    <i class="el-icon-document"></i>
                    <span>查看文章</span>
                </template>
            </el-menu-item>
        </el-submenu>
        <el-menu-item index="7">
            <i class="el-icon-menu"></i>
            <span slot="title">数据管理</span>
        </el-menu-item>
        <el-menu-item index="8">
            <i class="el-icon-menu"></i>
            <span slot="title">采集管理</span>
        </el-menu-item>
        <el-menu-item index="9">
            <i class="el-icon-menu"></i>
            <span slot="title">音乐管理</span>
        </el-menu-item>
        <el-menu-item index="9">
            <i class="el-icon-menu"></i>
            <span slot="title">附件管理</span>
        </el-menu-item>

    </el-menu>

</div>
</template>

<script>
export default {
    data: function () {
        return {
            isCollapse: false
        }

    },
    components: {

    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        }
    },
};
</script>

<style lang="less" scoped>

</style>
