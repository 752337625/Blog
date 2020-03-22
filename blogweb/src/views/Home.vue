<template>
<div class="homeConainer">
    <el-container style="height: 100%;">
        <el-header style="height:45px;" class="homeHeader">
            <blog-header></blog-header>
        </el-header>
        <el-container>
            <el-row type="flex" class="asideConainer">
                 <el-col  :lg="4" :xl="4" class="hidden-md-and-down aside-left">
                    <el-aside class="homeAside" style="width: auto;">
                        <blog-aside></blog-aside>
                    </el-aside>
                </el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="20" :xl="20">
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
        return {}

    },
    components: {
        blogHeader,
        blogAside,
        //blogMain
    },
    methods: {

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
