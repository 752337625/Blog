<template>
  <div id="mainConainer"></div>
</template>

<script>
import AMap from "AMap"; // 引入高德地图
//import Breadcrumb from "../pc_components/breadcrumb";
export default {
  data: function() {
    return {
      breadcrumb: {
        to: "首页",
        LevelOneto: "地图",
        LevelTwoto: "当前定位"
      },
      map: null
    };
  },
  components: {
    //Breadcrumb
  },
  mounted() {
    this.initMap();
  },
  methods: {
    plugin() {
      return;
    },
    initMap() {
      var _this = this;
      _this.map = new AMap.Map("mainConainer", {
        resizeEnable: true, //是否监控地图容器尺寸变化
        zoom: 11, //初始化地图层级
        center: [116.397428, 39.90923] //初始化地图中心点
      });
      AMap.plugin(
        ["AMap.ToolBar", "AMap.Scale", "AMap.MapType", "AMap.Geolocation"],
        function() {
          // 在图面添加工具条控件，工具条控件集成了缩放、平移、定位等功能按钮在内的组合控件
          _this.map.addControl(new AMap.ToolBar());
          // 在图面添加比例尺控件，展示地图在当前层级和纬度下的比例尺
          _this.map.addControl(new AMap.Scale());
          // 在图面添加类别切换控件，实现默认图层与卫星图、实施交通图层之间切换的控制
          _this.map.addControl(new AMap.MapType());

          var geolocation = new AMap.Geolocation({
            enableHighAccuracy: true, //是否使用高精度定位，默认:true
            timeout: 10000, //超过10秒后停止定位，默认：5s
            buttonPosition: "RB", //定位按钮的停靠位置
            buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true //定位成功后是否自动调整地图视野到定位点
          });
          _this.map.addControl(geolocation);
          geolocation.getCurrentPosition(function(status, result) {
            if (status == "complete") {
              _this.onComplete(result, _this);
            } else {
              _this.onError(result);
            }
          });
        }
      );
      _this.map.on("complete", function() {
        _this.$message.success("创建地图成功");
      });
    },
    onComplete(data, _this) {
      let lngat = (data.position.lng + "," + data.position.lat).split(",");
      var geocoder = new AMap.Geocoder({ city: "010", radius: 1000 });
      geocoder.getAddress(lngat, function(status, result) {
        if (status === "complete" && result.regeocode) {
        } else {
        }
      });
    },
    onError(result) {
      console.log(result);
    }
  }
};
</script>

<style lang="less" scoped>
#mainConainer {
  width: 100%;
  height: 100%;
}
</style>
