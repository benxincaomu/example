package org.sft.sample.web.login.cotroller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.sft.sample.common.error.ApplicationErrorCode;
import org.sft.sample.common.error.AssertUtil;
import org.sft.sample.web.base.BaseController;
import org.sft.sample.web.user.model.User;
import org.sft.sample.web.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"login"})
public class LoginController extends BaseController {
	@Resource
	private UserService userService;

	@RequestMapping("login")
	public User login(User user, String validateCode) {
//		Object validateCode0 = (String) getSession().getAttribute("validateCode");
//		if (validateCode.equals(validateCode0)) {
//			AssertUtil.error(ApplicationErrorCode.VALIDATECODE_FAILURE);
//		}
		User user0 = userService.findUserByUserName(user.getUserName());
		if (user0== null ||!user0.getPassword().equalsIgnoreCase(DigestUtils.md5Hex(user.getPassword()))) {
			AssertUtil.error(ApplicationErrorCode.USERNAME_OR_PASSWORD_FAILURE,user.getUserName());
		}
		getSession().setAttribute("user", user0);
		return user0;
	}

	@GetMapping({ "authCode" })
	public void getAuthCode(HttpServletResponse response) throws IOException {
		int width = 93;
		int height = 37;
		Random random = new Random();
		// 设置response头信息
		// 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 生成缓冲区image类
		BufferedImage image = new BufferedImage(width, height, 1);
		// 产生image类的Graphics用于绘制操作
		Graphics g = image.getGraphics();
		// Graphics类的样式
		g.setColor(this.getRandColor(200, 250));
		g.setFont(new Font("Bookman Old Style", 0, 28));
		g.fillRect(0, 0, width, height);
		// 绘制干扰线
		for (int i = 0; i < 40; i++) {
			g.setColor(this.getRandColor(130, 200));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1);
		}
		char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
		        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		// 绘制字符
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			String rand = String.valueOf(chars[random.nextInt(36)]);
			sb.append(rand);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 28);
		}
		// 将字符保存到session中用于前端的验证
		getSession().setAttribute("validateCode", sb.toString());
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
		response.getOutputStream().flush();

	}

	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
