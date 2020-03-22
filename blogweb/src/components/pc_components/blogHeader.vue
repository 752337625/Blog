<template>
<div class="blogHeadConainer">
    <el-row class="navbar-header">
        <el-col :xs="24" :sm="24" :md=24 :lg="4" :xl="4">
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
                    <el-col :xs="3" :sm="3" :md="3" class="hidden-lg-only menu-icon">
                        <i class="iconfont iconmianbaoxie"></i>
                    </el-col>
                </el-row>
            </div>
        </el-col>
        <el-col :lg="20" :xl="20" class="hidden-md-and-down">
            <div class="navbar-header-rigth">
                <el-row>
                    <el-col :span="24" class="iconfontContent">
                        <div class="iconfontBorder">
                            <div>
                                <i class="iconfont iconmianbaoxie"></i>
                            </div>
                            <div @click="showCard('messageInfo')">
                                <i class="iconfont iconnotificationbellring"></i>
                            </div>
                            <div @click="showCard('menuInfo')">
                                <i class="iconfont iconicon-"></i>
                            </div>
                        </div>
                        <div class="iconfontBorder">
                            <div class="portraitMale" @click="showCard('userInfo')">
                                <!-- <p style=" padding-right: 0.4rem;font-size: 1.5rem;line-height: 45px;    ">江南一点雨</p> -->
                                <i class="iconfont icon24gl-portraitMale" style="padding:0 10px"></i>
                            </div>
                            <div style="width:100px">
                                <!-- <i class="iconfont iconmianbaoxie"></i> -->
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
    <blogHeadCard v-show="visible" :info="info" :client='client'></blogHeadCard>
</div>
</template>

<script>
import blogHeadCard from './pc_header_small_components/blogHeaderCard'
export default {
    data: function () {
        return {
            visible: false,
            userInfo: {
                name: '王宏伟',
                age: 36,
                adder: '奶东村',
            },
            client: {
                clientX: '',
                clientY: '',
            },
            menuInfo: {
                name: '海贼王',
            },
            messageInfo: {
                name: '王家卫',
            },
            info: '',

        }

    },
    components: {
        blogHeadCard
    },
    methods: {
        showCard(mess) {
            this.visible = !this.visible
            this.client.clientX = event.clientX - event.offsetX + 'px'
            this.client.clientY = '50px'
            this.info = this.$data[mess]
            event.preventDefault()

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
    font-size: 1.9rem;
    line-height: 45px;
    display: block;
}

.menu-icon {
    text-align: right;
}

.blogger {
    display: flex;
    padding-left: 1.4rem;

}

.iconfontContent {
    display: flex;
    justify-content: space-between;
}

.iconblogger {
    font-size: 1.9rem;
    padding-right: 0.5rem;
    display: block;

}

.iconfontContent .portraitMale {
    display: flex;
    width: auto;
    color: #758697;
    border-left: 1px solid rgba(0, 0, 0, 0.05);
}

.blogger p {
    font-size: 1.9rem;
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

.iconfontContent .iconfontBorder>div:hover {
    background-color: #F2F2F2;
    cursor: pointer;
}

.iconfontBorder>div {
    border-right: 1px solid rgba(0, 0, 0, 0.05);
    width: 50px;
    text-align: center;
}

.iconfontBorder>div i {
    font-size: 1.9rem;
    color: #758697;
    line-height: 45px;
    display: block;
}
</style>
