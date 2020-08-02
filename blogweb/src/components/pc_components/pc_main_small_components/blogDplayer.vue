<template>
  <div class="" style="height: 100%;" id="dplayer">
  </div>
</template>
<script>
  //import 'dplayer/dist/DPlayer.min.css';
  import DPlayer from 'dplayer';
  export default {
    data: function ( ) {
      return {};
    },
    components: {},
    mounted( ) {
      const dp = new DPlayer( {
        container: document.getElementById( 'dplayer' ),
        video: {
          url: 'https://csrc.vcloud.dogecdn.com/vcloud/17/v/20190424/1556036075_818c4125ec9c8cbc7a7a8a7cc1601512/1037/7d515b22c4958598c0fbd1e6290a5ca5.mp4?vkey=36390BCF0E3F5CA576E772BE9976496F2EFB19C783A888DEB9ADAF677188D9D03FEEFED1E0539A1CA09A4BC987F6FCD58A47D66B66CAE69C5918A7B7824436DCE9DE19E46778BAD8BAF4C66C602A01B7D0FE66363481B22F3C48A1DC2796D278D835F361EFF9CB89874C009ED264523FBFF108A8BE494746782233BFF0155AFBEB56CF41371C923347C8C52C5B1704E2&tkey=1589259592ddfec023ab',
        },
        autoplay: false,
        theme: '#ccc',
        loop: true,
        mutex: true,
        volume: 0.7,
        screenshot: true,
        hotkey: true,
        preload: 'auto',
      } );
    },
    methods: {}
  };
</script>
<style lang="less" scoped>
</style>
