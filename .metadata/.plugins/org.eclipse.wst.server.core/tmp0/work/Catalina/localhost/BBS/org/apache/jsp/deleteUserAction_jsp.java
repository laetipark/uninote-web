/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.52
 * Generated at: 2022-05-13 15:04:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.UserDAO;
import bbs.BbsDAO;
import bbs.StudyboardDAO;
import file.FileDAO;
import map.CountsDAO;
import map.ItemDAO;
import map.LineDAO;
import map.PublicmapDAO;
import java.io.File;
import java.io.PrintWriter;
import org.apache.commons.net.ftp.*;
import java.io.*;

public final class deleteUserAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 
	public static void deleteFile(String path) {
		File deleteFolder = new File(path);

		if (deleteFolder.exists()) {
			File[] deleteFolderList = deleteFolder.listFiles();

			for (int i = 0; i < deleteFolderList.length; i++) {
				if (deleteFolderList[i].isFile()) {
					deleteFolderList[i].delete();
				} else {
					deleteFile(deleteFolderList[i].getPath());
				}
				deleteFolderList[i].delete();
			}
			deleteFolder.delete();
		}
	}
	
    public static void removeDirectory(FTPClient ftpClient, String parentDir,
            String currentDir) throws IOException {
    	ftpClient.setControlEncoding("euc-kr");
        String dirToList = parentDir;
        if (!currentDir.equals("")) {
            dirToList += "/" + currentDir;
        }
 
        FTPFile[] subFiles = ftpClient.listFiles(dirToList);
 
        if (subFiles != null && subFiles.length > 0) {
            for (FTPFile aFile : subFiles) {
                String currentFileName = aFile.getName();
                if (currentFileName.equals(".") || currentFileName.equals("..")) {
                    // skip parent directory and the directory itself
                    continue;
                }
                String filePath = parentDir + "/" + currentDir + "/"
                        + currentFileName;
                if (currentDir.equals("")) {
                    filePath = parentDir + "/" + currentFileName;
                }
 
                if (aFile.isDirectory()) {
                    // remove the sub directory
                    removeDirectory(ftpClient, dirToList, currentFileName);
                } else {
                    // delete the file
                    boolean deleted = ftpClient.deleteFile(filePath);
                    if (deleted) {
                        System.out.println("DELETED the file: " + filePath);
                    } else {
                        System.out.println("CANNOT delete the file: "
                                + filePath);
                    }
                }
            }
 
            // finally, remove the directory itself
            boolean removed = ftpClient.removeDirectory(dirToList);
            if (removed) {
                System.out.println("REMOVED the directory: " + dirToList);
            } else {
                System.out.println("CANNOT remove the directory: " + dirToList);
            }
        }
    }
	
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("org.apache.commons.net.ftp");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("map.LineDAO");
    _jspx_imports_classes.add("bbs.BbsDAO");
    _jspx_imports_classes.add("map.PublicmapDAO");
    _jspx_imports_classes.add("map.CountsDAO");
    _jspx_imports_classes.add("map.ItemDAO");
    _jspx_imports_classes.add("bbs.StudyboardDAO");
    _jspx_imports_classes.add("file.FileDAO");
    _jspx_imports_classes.add("user.UserDAO");
    _jspx_imports_classes.add("java.io.File");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--\r\n");
      out.write("서동학: 전체적인 코딩\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
request.setCharacterEncoding("UTF-8");
      out.write('\r');
      out.write('\n');
      user.User user = null;
      user = (user.User) _jspx_page_context.getAttribute("user", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (user == null){
        user = new user.User();
        _jspx_page_context.setAttribute("user", user, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "userID", request.getParameter("userID"), request, "userID", false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "userPassword", request.getParameter("userPassword"), request, "userPassword", false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "userName", request.getParameter("userName"), request, "userName", false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "userEmail", request.getParameter("userEmail"), request, "userEmail", false);
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>회원탈퇴</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	");

	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
		System.out.println(userID);
	}
	if (userID == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인된 상태가 아닙니다.')");
		script.println("location.href = 'home.jsp'");
		script.println("</script>");
	} else {
		UserDAO userDAO = new UserDAO();
		int result = userDAO.delete(userID);
		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('실패했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			// 유저와 관련된 모든 db 삭제
			
			BbsDAO bbsDAO = new BbsDAO();
			bbsDAO.deleteUser(userID);

			StudyboardDAO studyboardDAO = new StudyboardDAO();
			studyboardDAO.deleteUser(userID);

			// 유저가 업로드한 파일들도 모두 삭제
			FileDAO fileDAO = new FileDAO();
			fileDAO.deleteUser(userID);

			
			
			
			
			
			
			
			
			
			
			String path = "/www/upload"; // 변경이전 폴더 경로
			FTPClient ftp = null;
			try {
				ftp = new FTPClient();
				ftp.setControlEncoding("UTF-8"); 
				ftp.connect("183.111.138.172"); //"192.168.0.35"
				ftp.login("hjk709914", "tiger123*"); //"MeongDdi", "1234"
				ftp.enterLocalPassiveMode();
				
				ftp.changeWorkingDirectory(path);//파일 가져올 디렉터리 위치
				if(ftp.changeWorkingDirectory(path)) {
					System.out.println("FTP diretory set");
				}
				//ftp.setFileType(FTP.BINARY_FILE_TYPE);//파일 타입 설정 기본적으로 파일을 전송할떄는 BINARY타입을 사용합니다.
				
				int reply = ftp.getReplyCode();
			    if (!FTPReply.isPositiveCompletion(reply)) {
			    	ftp.disconnect();
			        System.out.println("FTP server refused connection.");
			    } else {
			    	System.out.println("FTP connected");
			        //System.out.print(ftpClient.getReplyString());
			    }

				//File f = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/" + request.getParameter("file"));//로컬에 다운받아 설정할 이름
				//System.out.println(f.getName());
				//FileOutputStream fos = null;
				try {
					//ftp.removeDirectory(itemID);
					removeDirectory(ftp, path, userID);
					
					//fos = new FileOutputStream(f);
					//boolean isSuccess = ftp.retrieveFile(request.getParameter("file"), fos);//ftp서버에 존재하는 해당명의 파일을 다운로드 하여 fos에 데이터를 넣습니다.
					/*if (isSuccess) {
						System.out.println("다운로드를 성공 하였습니다.");
					} else {
						System.out.println("다운로드 실패하여습니다.");
					}
					*/
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					
				}
				ftp.logout();
			} catch (Exception e) {
				System.out.println("Socket:" + e.getMessage());
			} finally {
				if (ftp != null && ftp.isConnected()) {
					try {
						ftp.disconnect();//ftp연결 끊기
					} catch (IOException e) {
					}
				}
			}
			/*
			String path = "D:/JSP/upload/" + userID; //경로

			File deleteFolder = new File(path);
			deleteFile(path);
			*/
			
			
			
			
			
			
			
			
			

			CountsDAO countsDAO = new CountsDAO();
			countsDAO.deleteCounts(userID);

			ItemDAO itemDAO = new ItemDAO();
			itemDAO.deleteUser(userID);

			LineDAO lineDAO = new LineDAO();
			lineDAO.deleteUser(userID);

			PublicmapDAO publicmapDAO = new PublicmapDAO();
			publicmapDAO.deleteUser(userID);

			session.invalidate();
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'home.jsp'"); // 이전 화면으로 새로고침된 화면 location.href = document.referrer;
			script.println("</script>");
		}

	}
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<!-- 탈퇴한 유저가 업로드한 파일과 폴더를 삭제하는 함수 -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}