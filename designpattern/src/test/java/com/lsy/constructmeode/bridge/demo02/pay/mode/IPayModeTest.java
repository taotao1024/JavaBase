package com.lsy.constructmeode.bridge.demo02.pay.mode;

import com.lsy.constructmeode.bridge.demo02.pay.channel.Pay;
import com.lsy.constructmeode.bridge.demo02.pay.channel.impl.WxPay;
import com.lsy.constructmeode.bridge.demo02.pay.channel.impl.ZfbPay;
import com.lsy.constructmeode.bridge.demo02.pay.mode.impl.PayCypher;
import com.lsy.constructmeode.bridge.demo02.pay.mode.impl.PayFaceMode;
import com.lsy.constructmeode.bridge.demo02.pay.mode.impl.PayFingerprintMode;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class IPayModeTest {
    @Test
    public void testPlay01() {

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        String result = wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));
        Assert.assertEquals("测试失败", "0000", result);
    }

    @Test
    public void testPlay02() {

        System.out.println("\r\n模拟测试场景；微信支付、指纹方式。");
        Pay wxPay = new WxPay(new PayFingerprintMode());
        String result = wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));
        Assert.assertEquals("测试失败", "0000", result);
    }

    @Test
    public void testPlay03() {

        System.out.println("\r\n模拟测试场景；微信支付、密码方式。");
        Pay wxPay = new WxPay(new PayCypher());
        String result = wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));
        Assert.assertEquals("测试失败", "0000", result);
    }

    @Test
    public void testPlay04() {
        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        String result = zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
        Assert.assertEquals("测试失败", "0000", result);
    }

    @Test
    public void testPlay05() {
        System.out.println("\r\n模拟测试场景；支付宝支付、人脸方式。");
        Pay zfbPay = new ZfbPay(new PayFaceMode());
        String result = zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
        Assert.assertEquals("测试失败", "0000", result);
    }

    @Test
    public void testPlay06() {
        System.out.println("\r\n模拟测试场景；支付宝支付、密码方式。");
        Pay zfbPay = new ZfbPay(new PayCypher());
        String result = zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
        Assert.assertEquals("测试失败", "0000", result);
    }


}