<template>
<div class="homeConainer">
    <el-container style="height: 100%;">
        <el-header style="height:45px;" class="homeHeader">
            <blog-header @ShowMenuListInfo="ShowMenuList"></blog-header>
        </el-header>
        <el-container>
            <el-row type="flex" class="asideConainer">
                 <el-col :md="4" :lg="4" :xl="4" :style="{width:isCollapse?'64px':''}" class="hidden-sm-and-down aside-left">
                    <el-aside class="homeAside" style="height: 100%;width:auto;">
                        <blog-aside :isCollapse='isCollapse'></blog-aside>
                    </el-aside>
                </el-col>
                <el-col :xs="24" :sm="24" :md="isCollapse?24:20" :lg="isCollapse?24:20" :xl="isCollapse?24:20">
                        <el-main class="homeMain">
                            <router-view></router-view>
                             <!-- <blog-main></blog-main> -->
                        </el-main>
                </el-col>
            </el-row>
        </el-container>
    </el-container>
</div>
</template>

<script>
import blogHeader from '../components/pc_components/blogHeader'
import blogAside from '../components/pc_components/blogAside'
//import blogMain from '../components/pc_components/blogMain'
export default {
    data: function () {
        return {
            isCollapse:false,
        }

    },
    components: {
        blogHeader,
        blogAside,
        //blogMain
    },
    methods: {
        ShowMenuList(visible){
            this.isCollapse=visible
        }
    },
};
</script>

<style lang="less" scoped>
.homeConainer {
    height: 100%;
    width: 100%;
    background-color: white;
}

.homeHeader {
    padding: 0;
    background-color: white;
}

.homeAside {
    background-color: #263238;
}

.homeMain {
   height: 100%;
   background-color: #ECF0F5;
}
.asideConainer{
    width: 100%;
}
.aside-left{
    background-color:#263238;
    height: 100%;
}
</style>
