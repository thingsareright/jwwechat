package com.jw.factory;

import com.jw.bean.WeChatBaseBean;
import com.jw.bean.response.*;
import com.jw.bean.response.inner.Image;
import com.jw.bean.response.inner.Music;
import com.jw.bean.response.inner.Video;
import com.jw.bean.response.inner.Voice;

public class ResponseMsgBuilder {
    private String requestToUserName;
    private String requestFromUserName;

    public ResponseMsgBuilder(WeChatBaseBean msgBean) {
        this.requestFromUserName = msgBean.getFromUserName();
        this.requestToUserName = msgBean.getToUserName();
    }

    public WeChatResponseTextBean buildDefaultSuccessTextBean() {
        WeChatResponseTextBean defaultBean = new WeChatResponseTextBean();
        doBuildBaseBean(defaultBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_TEXT);
        defaultBean.setContent("success");
        return defaultBean;
    }

    public String buildDefaultEmtpyMsg() {
        return "";
    }

    public WeChatResponseTextBean buildResponseTextBean(String content) {
        WeChatResponseTextBean textBean = new WeChatResponseTextBean();
        doBuildBaseBean(textBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_TEXT);
        textBean.setContent(content);
        return textBean;
    }

    public WeChatResponseImageBean buildResponseImageBean(String mediaId) {
        WeChatResponseImageBean imageBean = new WeChatResponseImageBean();
        doBuildBaseBean(imageBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_IMAGE);

        Image image = new Image();
        image.setMediaId(mediaId);
        imageBean.setImage(image);

        return imageBean;
    }

    public WeChatResponseVoiceBean buildResponseVoiceBean(String mediaId) {

        WeChatResponseVoiceBean voiceBean = new WeChatResponseVoiceBean();
        doBuildBaseBean(voiceBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_VOICE);

        Voice voice = new Voice();
        voice.setMediaId(mediaId);
        voiceBean.setVoice(voice);

        return voiceBean;
    }

    public WeChatResponseVideoBean buildResponseVideoBean(String mediaId,String title,String description) {

        WeChatResponseVideoBean videoBean = new WeChatResponseVideoBean();
        doBuildBaseBean(videoBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_VIDEO);

        Video video =new Video();
        video.setMediaId(mediaId);
        video.setTitle(title);
        video.setDescription(description);
        videoBean.setVideo(video);

        return videoBean;

    }

    public WeChatResponseMusicBean buildResponseMusciBean(String thumbMediaId,String title,String description,String musicURL,String hQMusicUrl ) {

        WeChatResponseMusicBean musicBean = new WeChatResponseMusicBean();
        doBuildBaseBean(musicBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_MUSIC);
        Music music = new Music();
        music.setDescription(description);
        music.setThumbMediaId(thumbMediaId);
        music.setTitle(title);
        music.sethQMusicUrl(hQMusicUrl);
        music.setMusicURL(musicURL);
        musicBean.setMusic(music);

        return musicBean;
    }



    private void doBuildBaseBean(WeChatResponseBaseBean bean, String msgType) {
        bean.setFromUserName(this.requestToUserName);
        bean.setToUserName(this.requestFromUserName);
        bean.setCreateTime(System.currentTimeMillis()+ "");
        bean.setMsgType(msgType);
    }


}
