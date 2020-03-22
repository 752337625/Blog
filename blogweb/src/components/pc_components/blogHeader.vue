<template>
<div class="blogHeadConainer">
    <el-row class="navbar-header">
        <el-col :xs="24" :sm="24" :md=24 :lg="3" :xl="4">
            <div class="navbar-header-left">
                <el-row type="flex" justify="flex-start">
                    <el-col :xs="21" :sm="21" :md="21" :lg="20" :xl="20" class="blogger">
                        <div>
                            <i class="iconfont iconblogger"></i>
                        </div>
                        <div>
                            <p>Blog</p>
                        </div>
                    </el-col>
                    <el-col :xs="3" :sm="3" :md="3"  class="hidden-lg-only menu-icon">
                        <i class="iconfont iconmianbaoxie"></i>
                    </el-col>
                </el-row>
            </div>
        </el-col>
        <el-col  :lg="21" :xl="20" class="hidden-md-and-down">
            <div class="navbar-header-rigth">
                <el-row>
                    <el-col :span="24" class="iconfontContent">
                        <div class="iconfontBorder">
                            <div>
                                <i class="iconfont iconmianbaoxie"></i>
                            </div>
                            <div>
                                <i class="iconfont iconnotificationbellring"></i>
                            </div>
                            <div>
                                <i class="iconfont iconicon-"></i>
                            </div>
                        </div>
                        <div class="iconfontBorder">
                            <div style=" border-left: 1px solid rgba(0, 0, 0, 0.05);width:100px">
                                <!-- <i class="iconfont iconmianbaoxie"></i> -->
                            </div> 
                            <div class="portraitMale" @click="showCard">
                                <p style=" padding-right: 0.1rem;font-size: 0.2rem;line-height: 45px;">江南一点雨</p>
                                <i class="iconfont icon24gl-portraitMale"></i>
                            </div>
                            <div>
                                <i class="iconfont icondots-vertical"></i>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </div>
        </el-col>
    </el-row>
    <blogHeadCard :visible="visible"></blogHeadCard>
</div>
</template>

<script>
import blogHeadCard from './pc_header_small_components/blogHeaderCard'
export default {
    data: function () {
        return {
            visible: true
 

        }

    },
    components: {
        blogHeadCard
    },
    methods: {
        showCard(){

        }
    },
};
</script>

<style lang="less" scoped>
.blogHeadConainer,
.navbar-header,
.navbar-header div,
.navbar-header-left,
.navbar-header-rigth {
    height: 100%;
    line-height: 45px;
}

.iconmianbaoxie,
.iconmenu-line,
.icondengluyemianyonghuming,
.iconicon- {
       font-size: 0.25rem;
    line-height: 45px;
}

.menu-icon {
    text-align: right;
}

.blogger {
    display: flex;
    padding-left: 0.4rem;

}

.iconfontContent {
    display: flex;
    justify-content: space-between;
}

.iconblogger {
         font-size: 0.25rem;
    padding-right: 0.1rem;
    display: block;


}

.iconfontContent .portraitMale {
    display: flex;
   
    width: auto;
    padding: 0 10px;
    color: #758697;
}

.blogger p {
      font-size: 0.25rem;
   line-height: 45px;
}

.navbar-header-left {
    background-color: #263238;
    color: white;
}

.navbar-header-rigth {
    background: white
}

.iconfontBorder {
    display: flex;
}
.iconfontContent .iconfontBorder>div:hover{
    background-color: #F2F2F2;
    cursor:pointer;
}
.iconfontBorder>div {
    border-right: 1px solid rgba(0, 0, 0, 0.05);
    width: 50px;
    text-align: center;
}

.iconfontBorder>div i {
        font-size: 0.25rem;
    color: #758697;
    line-height: 45px;
        display: block;
}
</style>
