package com.xw.springbootstudy.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xw.springbootstudy.util.LocaleMessageSourceUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String DEFAULT_ERROR_VIEW = "error";

    @Autowired
    private LocaleMessageSourceUtil localeMessageSourceUtil;

/*    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }*/
    

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public ResponseResult jsonException(Exception e) throws RuntimeException {
//        //输出错误信息，方便排查错误
//        LOG.error("jsonException:", e);
//        //返回给用户的信息
//        String code = null;
//        String msg = null;
//
//        if (e instanceof BasisException) {
//            BasisException be = (BasisException) e;
//            code = be.getCode();
//            msg = be.getMsg();
//        }
//
//        if (Strings.isNullOrEmpty(code)) {
//            code = "110999";
//        }
//        if (Strings.isNullOrEmpty(msg)) {
//            msg = localeMessageSourceUtil.getMessage(code);
//        }
//        ResponseResult responseResult = ResponseResult.build(code, msg);
//        return responseResult;
//    }
}