package cn.com.sealer.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bufferedImage = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		Color color = new Color(200, 150, 255);
		g.setColor(color);
		g.fillRect(0, 0, 68, 22);
		
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random random = new Random();
		int index;
		int length = chars.length;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 4; i ++){
			index = random.nextInt(length);
			char ch = chars[index];
			Color c = new Color(random.nextInt(50), random.nextInt(150), random.nextInt(250));
			g.setColor(c);
			g.drawString(ch + "", i*15+3, 18);
			sb.append(ch);
		}
		
		request.getSession().setAttribute("picCode", sb.toString());
		ImageIO.write(bufferedImage, "JPG", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
