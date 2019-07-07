package com.bussinesscom.Africa.GsuitAfrica.Utils;

public class HtmlTemplates {

	
	
	public static String templateReturn(String Title,String names,String phoneNumber,String location,String emailAdress,String company,String time,String toTime) {
 
	
		String descriptionMessage ="<a href=\\"+""+"\\rel=\"nofollow\" target=\"_blank\" title=\"W3C HTML validator\">"+names +":"+ emailAdress+"</a>"+" form "+ company+" Located in"+location+" Nairobi KENYA I Would Like To Book An Appointment With You At";
		
		
		String xx="<h2>"+Title+"</h2>\n" + 
				"<p>Hi Am"
				+descriptionMessage+"<em> "+time+" </em> To <em> "+toTime+" </em>.</p>\n";
	
		
		
		
		return xx;
//	return "<!DOCTYPE html>\n" + 
//			"<html lang=\"en\">\n" + 
//			"  <head>\n" + 
//			"    <!-- Required meta tags -->\n" + 
//			"    <meta charset=\"utf-8\">\n" + 
//			"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" + 
//			"\n" + 
//			"    <title>MeetMe - Resume Website Template</title>\n" + 
//			"\n" + 
//			"    <!-- Bootstrap CSS -->\n" + 
//			"   \n" + 
//			"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" >\n" + 
//			"  \n" + 
//			"    <!-- Main Style -->\n" + 
//			"    <style>\n" + 
//			"      @import url(\"https://fonts.googleapis.com/css?family=Shadows+Into+Light|Source+Sans+Pro:400,700\");\n" + 
//			"html {\n" + 
//			"  overflow-x: hidden;\n" + 
//			"}\n" + 
//			"\n" + 
//			"body {\n" + 
//			"  background: #fff;\n" + 
//			"  font-size: 14px;\n" + 
//			"  font-weight: 400;\n" + 
//			"  font-family: \"Source Sans Pro\", sans-serif;\n" + 
//			"  -webkit-box-sizing: border-box;\n" + 
//			"  -moz-box-sizing: border-box;\n" + 
//			"  box-sizing: border-box;\n" + 
//			"  -webkit-font-smoothing: subpixel-antialiased;\n" + 
//			"  color: #666;\n" + 
//			"  line-height: 25px;\n" + 
//			"  -webkit-backface-visibility: hidden;\n" + 
//			"  backface-visibility: hidden;\n" + 
//			"  overflow-x: hidden;\n" + 
//			"}\n" + 
//			"\n" + 
//			"h1, h2, h3, h4 {\n" + 
//			"  font-size: 38px;\n" + 
//			"  font-weight: 700;\n" + 
//			"  font-family: \"Source Sans Pro\", sans-serif;\n" + 
//			"}\n" + 
//			"\n" + 
//			".script-font {\n" + 
//			"  font-family: 'Shadows Into Light', cursive;\n" + 
//			"}\n" + 
//			"\n" + 
//			"a {\n" + 
//			"  -webkit-transition: all 0.2s linear;\n" + 
//			"  -moz-transition: all 0.2s linear;\n" + 
//			"  -o-transition: all 0.2s linear;\n" + 
//			"  transition: all 0.2s linear;\n" + 
//			"}\n" + 
//			"\n" + 
//			"a:hover {\n" + 
//			"  text-decoration: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			"a a:focus {\n" + 
//			"  outline: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			"p {\n" + 
//			"  font-weight: 400;\n" + 
//			"  font-family: \"Source Sans Pro\", sans-serif;\n" + 
//			"  margin: 0px;\n" + 
//			"  font-size: 14px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"ul, ol {\n" + 
//			"  list-style: outside none none;\n" + 
//			"  margin: 0;\n" + 
//			"  padding: 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			"ul li, ol li {\n" + 
//			"  list-style: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			".hero-heading {\n" + 
//			"  font-size: 48px;\n" + 
//			"  font-weight: 700;\n" + 
//			"  color: #fff;\n" + 
//			"  text-transform: capitalize;\n" + 
//			"  line-height: 70px;\n" + 
//			"  letter-spacing: 0.1rem;\n" + 
//			"}\n" + 
//			"\n" + 
//			".hero-sub-heading {\n" + 
//			"  font-size: 20px;\n" + 
//			"  font-weight: 400;\n" + 
//			"  color: #e6e6e6;\n" + 
//			"  line-height: 45px;\n" + 
//			"  letter-spacing: 0.1rem;\n" + 
//			"}\n" + 
//			"\n" + 
//			".section-titile-bg {\n" + 
//			"  display: inline;\n" + 
//			"  font-size: 115px;\n" + 
//			"  font-weight: 700;\n" + 
//			"  height: 100%;\n" + 
//			"  left: -173px;\n" + 
//			"  opacity: 0.1;\n" + 
//			"  position: absolute;\n" + 
//			"  top: -14px;\n" + 
//			"  width: 100%;\n" + 
//			"  text-align: center;\n" + 
//			"}\n" + 
//			"\n" + 
//			".section-title-header p {\n" + 
//			"  text: center;\n" + 
//			"  font-weight: 400;\n" + 
//			"  line-height: 26px;\n" + 
//			"  padding-bottom: 36px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".section-title {\n" + 
//			"  color: #252525;\n" + 
//			"  font-size: 38px;\n" + 
//			"  text-align: center;\n" + 
//			"  letter-spacing: 1px;\n" + 
//			"  line-height: 1;\n" + 
//			"  margin-bottom: 48px;\n" + 
//			"  padding: 0 10px;\n" + 
//			"  position: relative;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn {\n" + 
//			"  font-size: 14px;\n" + 
//			"  padding: 10px 30px;\n" + 
//			"  border-radius: 0px;\n" + 
//			"  cursor: pointer;\n" + 
//			"  font-weight: 400;\n" + 
//			"  color: #fff;\n" + 
//			"  border-radius: 4px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  -webkit-transition: all 0.2s linear;\n" + 
//			"  -moz-transition: all 0.2s linear;\n" + 
//			"  -o-transition: all 0.2s linear;\n" + 
//			"  transition: all 0.2s linear;\n" + 
//			"  display: inline-block;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn:focus,\n" + 
//			".btn:active {\n" + 
//			"  box-shadow: none;\n" + 
//			"  outline: none;\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn-common {\n" + 
//			"  background-color: #00b4d9;\n" + 
//			"  position: relative;\n" + 
//			"  z-index: 1;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn-common:hover {\n" + 
//			"  color: #fff;\n" + 
//			"  background-color: #21cff3;\n" + 
//			"  box-shadow: 0 6px 22px rgba(0, 0, 0, 0.1);\n" + 
//			"  transition: all .2s ease-in-out;\n" + 
//			"  -moz-transition: all .2s ease-in-out;\n" + 
//			"  -webkit-transition: all .2s ease-in-out;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn-danger:hover {\n" + 
//			"  background-color: #f55262;\n" + 
//			"  border-color: #f55262;\n" + 
//			"  box-shadow: 0 6px 22px rgba(0, 0, 0, 0.1);\n" + 
//			"  transition: all .2s ease-in-out;\n" + 
//			"  -moz-transition: all .2s ease-in-out;\n" + 
//			"  -webkit-transition: all .2s ease-in-out;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn-border {\n" + 
//			"  color: #fff;\n" + 
//			"  background-color: transparent;\n" + 
//			"  border: 1px solid #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn-border:hover {\n" + 
//			"  border: 1px solid #fff;\n" + 
//			"  color: #fff;\n" + 
//			"  background-color: rgba(255, 255, 255, 0.2);\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn-lg {\n" + 
//			"  padding: 14px 33px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  font-size: 16px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn-rm {\n" + 
//			"  padding: 7px 10px;\n" + 
//			"  text-transform: capitalize;\n" + 
//			"}\n" + 
//			"\n" + 
//			"button:focus {\n" + 
//			"  outline: none !important;\n" + 
//			"}\n" + 
//			"\n" + 
//			".icon-close, .icon-check {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li {\n" + 
//			"  display: inline-block;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li a {\n" + 
//			"  color: #000;\n" + 
//			"  background: #fff;\n" + 
//			"  width: 35px;\n" + 
//			"  height: 35px;\n" + 
//			"  line-height: 38px;\n" + 
//			"  display: block;\n" + 
//			"  text-align: center;\n" + 
//			"  border-radius: 100%;\n" + 
//			"  font-size: 16px;\n" + 
//			"  margin: 15px 6px 12px 6px;\n" + 
//			"  transition: all 0.3s ease-in-out 0s;\n" + 
//			"  -moz-transition: all 0.3s ease-in-out 0s;\n" + 
//			"  -webkit-transition: all 0.3s ease-in-out 0s;\n" + 
//			"  -o-transition: all 0.3s ease-in-out 0s;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li a:hover {\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li .facebook:hover {\n" + 
//			"  background: #3b5999;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li .twitter:hover {\n" + 
//			"  background: #4A9CEC;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li .instagram:hover {\n" + 
//			"  background: #D6274D;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li .linkedin:hover {\n" + 
//			"  background: #1260A2;\n" + 
//			"}\n" + 
//			"\n" + 
//			".social-icon li .google:hover {\n" + 
//			"  background: #CE332A;\n" + 
//			"}\n" + 
//			"\n" + 
//			"/* ScrollToTop */\n" + 
//			"a.back-to-top {\n" + 
//			"  display: none;\n" + 
//			"  position: fixed;\n" + 
//			"  bottom: 18px;\n" + 
//			"  right: 15px;\n" + 
//			"  text-decoration: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			"a.back-to-top i {\n" + 
//			"  display: block;\n" + 
//			"  font-size: 22px;\n" + 
//			"  width: 40px;\n" + 
//			"  height: 40px;\n" + 
//			"  line-height: 40px;\n" + 
//			"  color: #fff;\n" + 
//			"  background: #00b4d9;\n" + 
//			"  border-radius: 2px;\n" + 
//			"  text-align: center;\n" + 
//			"  transition: all 0.2s ease-in-out;\n" + 
//			"  -moz-transition: all 0.2s ease-in-out;\n" + 
//			"  -webkit-transition: all 0.2s ease-in-out;\n" + 
//			"  -o-transition: all 0.2s ease-in-out;\n" + 
//			"  box-shadow: 0 0 4px rgba(0, 0, 0, 0.14), 0 4px 8px rgba(0, 0, 0, 0.28);\n" + 
//			"}\n" + 
//			"\n" + 
//			"a.back-to-top:hover, a.back-to-top:focus {\n" + 
//			"  text-decoration: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#loader {\n" + 
//			"  position: fixed;\n" + 
//			"  background: #fff;\n" + 
//			"  top: 0;\n" + 
//			"  left: 0;\n" + 
//			"  width: 100%;\n" + 
//			"  height: 100%;\n" + 
//			"  z-index: 9999999999;\n" + 
//			"}\n" + 
//			"\n" + 
//			".square-spin {\n" + 
//			"  position: absolute;\n" + 
//			"  top: 50%;\n" + 
//			"  left: 50%;\n" + 
//			"  margin-left: -40px;\n" + 
//			"  margin-top: -40px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".square-spin img {\n" + 
//			"  max-width: 64px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".section-padding {\n" + 
//			"  padding: 60px 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#about .img-thumb img {\n" + 
//			"  border: 8px solid #fff;\n" + 
//			"  box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.2);\n" + 
//			"}\n" + 
//			"\n" + 
//			".profile-wrapper {\n" + 
//			"  padding: 45px 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			".profile-wrapper .btn {\n" + 
//			"  margin: 10px 10px 0px 0px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".profile-wrapper .btn i {\n" + 
//			"  vertical-align: middle;\n" + 
//			"  margin-right: 5px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".about-profile {\n" + 
//			"  position: relative;\n" + 
//			"  margin: 20px 0 20px 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			".about-profile .pro-title {\n" + 
//			"  font-weight: 700;\n" + 
//			"  color: #040404;\n" + 
//			"  position: relative;\n" + 
//			"  width: 120px;\n" + 
//			"  display: inline-block;\n" + 
//			"  margin-bottom: 5px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".about-profile .pro-title:after {\n" + 
//			"  position: absolute;\n" + 
//			"  content: ':';\n" + 
//			"  color: #040404;\n" + 
//			"  font-size: 14px;\n" + 
//			"  left: 77px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".about-profile .admin-sign {\n" + 
//			"  position: absolute;\n" + 
//			"  right: 45px;\n" + 
//			"  bottom: 10px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".counter-section {\n" + 
//			"  background: url(../img/background/bg-1.jpg);\n" + 
//			"  overflow: hidden;\n" + 
//			"  position: relative;\n" + 
//			"}\n" + 
//			"\n" + 
//			".counter-section:before {\n" + 
//			"  content: '';\n" + 
//			"  position: absolute;\n" + 
//			"  top: 0;\n" + 
//			"  bottom: 0;\n" + 
//			"  width: 100%;\n" + 
//			"  height: 100%;\n" + 
//			"  background: rgba(0, 0, 0, 0.5);\n" + 
//			"}\n" + 
//			"\n" + 
//			".counter-section .counter {\n" + 
//			"  padding: 30px 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			".counter-section .counter .icon {\n" + 
//			"  margin-bottom: 30px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".counter-section .counter .icon i {\n" + 
//			"  font-size: 48px;\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".counter-section .counter p {\n" + 
//			"  font-size: 18px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  color: #fff;\n" + 
//			"  font-weight: 400;\n" + 
//			"  letter-spacing: 1px;\n" + 
//			"  margin: 30px 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			".counter-section .counter .counterUp {\n" + 
//			"  color: #fff;\n" + 
//			"  font-size: 42px;\n" + 
//			"  margin-top: 15px;\n" + 
//			"  font-weight: 700;\n" + 
//			"}\n" + 
//			"\n" + 
//			"/* Resume */\n" + 
//			".timeline {\n" + 
//			"  position: relative;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline .timelin-title {\n" + 
//			"  font-size: 20px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  margin-left: 25px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li {\n" + 
//			"  padding: 0 20px 20px 30px;\n" + 
//			"  list-style: none;\n" + 
//			"  border-left: 2px solid #f1f1f1;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li .content-text {\n" + 
//			"  background: #f2f2f2;\n" + 
//			"  padding: 20px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li .line-title {\n" + 
//			"  font-size: 16px;\n" + 
//			"  line-height: 6px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li span {\n" + 
//			"  font-size: 12px;\n" + 
//			"  padding: 9px 0;\n" + 
//			"  display: block;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li .line-text {\n" + 
//			"  color: #888;\n" + 
//			"  line-height: 18px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li:first-child:before {\n" + 
//			"  border: 0;\n" + 
//			"  background: none;\n" + 
//			"  position: relative;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li:last-child {\n" + 
//			"  padding: 0 20px 0px 30px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li:before {\n" + 
//			"  content: \"\";\n" + 
//			"  border: solid 2px;\n" + 
//			"  width: 8px;\n" + 
//			"  height: 8px;\n" + 
//			"  border-radius: 50px;\n" + 
//			"  -moz-border-radius: 50px;\n" + 
//			"  -webkit-border-radius: 50px;\n" + 
//			"  font-size: 8px;\n" + 
//			"  margin-left: -35px;\n" + 
//			"  font-weight: 400;\n" + 
//			"  background: #fff;\n" + 
//			"  display: block;\n" + 
//			"  position: absolute;\n" + 
//			"  margin-top: 18px;\n" + 
//			"  border-color: #00b4d9 !important;\n" + 
//			"}\n" + 
//			"\n" + 
//			".timeline li:first-child i {\n" + 
//			"  font-size: 20px;\n" + 
//			"  float: left;\n" + 
//			"  margin-left: -30px;\n" + 
//			"  line-height: 50px;\n" + 
//			"  border-radius: 30px;\n" + 
//			"  margin: -12px -55px;\n" + 
//			"  background: #00b4d9;\n" + 
//			"  color: #fff;\n" + 
//			"  width: 50px;\n" + 
//			"  height: 50px;\n" + 
//			"  text-align: center;\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar-brand {\n" + 
//			"  position: relative;\n" + 
//			"  padding: 0px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".top-nav-collapse {\n" + 
//			"  background: #fff;\n" + 
//			"  z-index: 999999;\n" + 
//			"  top: 0px !important;\n" + 
//			"  min-height: 58px;\n" + 
//			"  box-shadow: 0px 3px 6px 3px rgba(0, 0, 0, 0.06);\n" + 
//			"  -webkit-animation-duration: 1s;\n" + 
//			"  animation-duration: 1s;\n" + 
//			"  -webkit-animation-fill-mode: both;\n" + 
//			"  animation-fill-mode: both;\n" + 
//			"  -webkit-animation-name: fadeInDown;\n" + 
//			"  animation-name: fadeInDown;\n" + 
//			"  background: #fff !important;\n" + 
//			"}\n" + 
//			"\n" + 
//			".top-nav-collapse .navbar-brand {\n" + 
//			"  top: 0px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".top-nav-collapse .navbar-brand img {\n" + 
//			"  width: 65%;\n" + 
//			"}\n" + 
//			"\n" + 
//			".top-nav-collapse .navbar-nav .nav-link {\n" + 
//			"  color: #333 !important;\n" + 
//			"  margin-top: 0px !important;\n" + 
//			"  margin-bottom: 0px !important;\n" + 
//			"}\n" + 
//			"\n" + 
//			".top-nav-collapse .navbar-nav .nav-link:hover {\n" + 
//			"  cursor: pointer;\n" + 
//			"  color: #00b4d9 !important;\n" + 
//			"}\n" + 
//			"\n" + 
//			".top-nav-collapse .navbar-nav li.active a.nav-link {\n" + 
//			"  color: #00b4d9 !important;\n" + 
//			"}\n" + 
//			"\n" + 
//			".indigo {\n" + 
//			"  background: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".menu-bg {\n" + 
//			"  background: transparent;\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar-expand-lg .navbar-nav .nav-link i {\n" + 
//			"  font-size: 28px;\n" + 
//			"  color: #00b4d9;\n" + 
//			"  vertical-align: middle;\n" + 
//			"  -webkit-transition: all 0.3s ease-in-out;\n" + 
//			"  -moz-transition: all 0.3s ease-in-out;\n" + 
//			"  transition: all 0.3s ease-in-out;\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar-expand-lg .navbar-nav .nav-link i:hover {\n" + 
//			"  color: #21cff3;\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar-expand-lg .navbar-nav .nav-link {\n" + 
//			"  color: #333;\n" + 
//			"  font-weight: 700;\n" + 
//			"  padding: 0 17px;\n" + 
//			"  margin-top: 15px;\n" + 
//			"  margin-bottom: 15px;\n" + 
//			"  line-height: 40px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  cursor: pointer;\n" + 
//			"  background: transparent;\n" + 
//			"  -webkit-transition: all 0.3s ease-in-out;\n" + 
//			"  -moz-transition: all 0.3s ease-in-out;\n" + 
//			"  transition: all 0.3s ease-in-out;\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar-expand-lg .navbar-nav li a:hover,\n" + 
//			".navbar-expand-lg .navbar-nav li .active > a,\n" + 
//			".navbar-expand-lg .navbar-nav li a:focus {\n" + 
//			"  color: #00b4d9;\n" + 
//			"  outline: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar {\n" + 
//			"  padding: 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar li.active a.nav-link {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown-toggle::after {\n" + 
//			"  display: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown-menu {\n" + 
//			"  margin: 0;\n" + 
//			"  padding: 0;\n" + 
//			"  display: none;\n" + 
//			"  position: absolute;\n" + 
//			"  z-index: 99;\n" + 
//			"  min-width: 210px;\n" + 
//			"  background-color: #fff;\n" + 
//			"  white-space: nowrap;\n" + 
//			"  border-radius: 4px;\n" + 
//			"  -webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);\n" + 
//			"  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);\n" + 
//			"  animation: fadeIn 0.4s;\n" + 
//			"  -webkit-animation: fadeIn 0.4s;\n" + 
//			"  -moz-animation: fadeIn 0.4s;\n" + 
//			"  -o-animation: fadeIn 0.4s;\n" + 
//			"  -ms-animation: fadeIn 0.4s;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown-menu:before {\n" + 
//			"  content: \"\";\n" + 
//			"  display: inline-block;\n" + 
//			"  position: absolute;\n" + 
//			"  bottom: 100%;\n" + 
//			"  left: 20%;\n" + 
//			"  margin-left: -5px;\n" + 
//			"  border-right: 10px solid transparent;\n" + 
//			"  border-left: 10px solid transparent;\n" + 
//			"  border-bottom: 10px solid #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown:hover .dropdown-menu {\n" + 
//			"  display: block;\n" + 
//			"  position: absolute;\n" + 
//			"  text-align: left;\n" + 
//			"  top: 100%;\n" + 
//			"  border: none;\n" + 
//			"  animation: fadeIn 0.4s;\n" + 
//			"  -webkit-animation: fadeIn 0.4s;\n" + 
//			"  -moz-animation: fadeIn 0.4s;\n" + 
//			"  -o-animation: fadeIn 0.4s;\n" + 
//			"  -ms-animation: fadeIn 0.4s;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown .dropdown-menu .dropdown-item {\n" + 
//			"  width: 100%;\n" + 
//			"  padding: 12px 20px;\n" + 
//			"  font-size: 14px;\n" + 
//			"  color: #333;\n" + 
//			"  border-bottom: 1px solid #f1f1f1;\n" + 
//			"  text-decoration: none;\n" + 
//			"  display: inline-block;\n" + 
//			"  float: left;\n" + 
//			"  clear: both;\n" + 
//			"  position: relative;\n" + 
//			"  outline: 0;\n" + 
//			"  transition: all 0.3s ease-in-out;\n" + 
//			"  -webkit-transition: all 0.3s ease-in-out;\n" + 
//			"  -moz-transition: all 0.3s ease-in-out;\n" + 
//			"  -o-transition: all 0.3s ease-in-out;\n" + 
//			"  -ms-transition: all 0.3s ease-in-out;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown .dropdown-menu .dropdown-item:last-child {\n" + 
//			"  border-bottom: none;\n" + 
//			"  border-bottom-left-radius: 4px;\n" + 
//			"  border-bottom-right-radius: 4px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown .dropdown-menu .dropdown-item:first-child {\n" + 
//			"  border-top-left-radius: 4px;\n" + 
//			"  border-top-right-radius: 4px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown .dropdown-item:focus,\n" + 
//			".dropdown .dropdown-item:hover,\n" + 
//			".dropdown .dropdown-item.active {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".dropdown-item.active, .dropdown-item:active {\n" + 
//			"  background: transparent;\n" + 
//			"}\n" + 
//			"\n" + 
//			".fadeInUpMenu {\n" + 
//			"  -webkit-animation-name: fadeInUpMenu;\n" + 
//			"  animation-name: fadeInUpMenu;\n" + 
//			"}\n" + 
//			"\n" + 
//			".slicknav_btn {\n" + 
//			"  border-color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".slicknav_menu .slicknav_icon-bar {\n" + 
//			"  background: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			"/* only small tablets */\n" + 
//			"@media (min-width: 768px) and (max-width: 991px) {\n" + 
//			"  #nav-main li a.nav-link {\n" + 
//			"    padding-top: 18px;\n" + 
//			"  }\n" + 
//			"}\n" + 
//			"\n" + 
//			".navbar-toggler {\n" + 
//			"  display: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			".mobile-menu {\n" + 
//			"  display: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			".slicknav_menu {\n" + 
//			"  display: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			"@media screen and (max-width: 768px) {\n" + 
//			"  .navbar-header {\n" + 
//			"    width: 100%;\n" + 
//			"  }\n" + 
//			"  .navbar-brand {\n" + 
//			"    position: absolute;\n" + 
//			"    padding: 0px 15px;\n" + 
//			"    top: 0;\n" + 
//			"  }\n" + 
//			"  .navbar-brand img {\n" + 
//			"    width: 75%;\n" + 
//			"  }\n" + 
//			"  #mobile-menu {\n" + 
//			"    display: none;\n" + 
//			"  }\n" + 
//			"  .slicknav_menu {\n" + 
//			"    display: block;\n" + 
//			"  }\n" + 
//			"  .slicknav_nav .active a {\n" + 
//			"    background: #E91E63;\n" + 
//			"    color: #fff;\n" + 
//			"  }\n" + 
//			"  .slicknav_nav a:hover,\n" + 
//			"  .slicknav_nav a:focus,\n" + 
//			"  .slicknav_nav .active {\n" + 
//			"    color: #00b4d9;\n" + 
//			"    outline: none;\n" + 
//			"    background: #f8f9fa;\n" + 
//			"  }\n" + 
//			"}\n" + 
//			"\n" + 
//			"/* ==========================================================================\n" + 
//			"3. Hero Area\n" + 
//			"========================================================================== */\n" + 
//			".hero-area-bg {\n" + 
//			"  background: url(../img/hero-area.jpg) no-repeat;\n" + 
//			"  background-size: cover;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area {\n" + 
//			"  color: #fff;\n" + 
//			"  overflow: hidden;\n" + 
//			"  position: relative;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .overlay {\n" + 
//			"  position: absolute;\n" + 
//			"  width: 100%;\n" + 
//			"  height: 100%;\n" + 
//			"  top: 0px;\n" + 
//			"  left: 0px;\n" + 
//			"  background: #0c0808;\n" + 
//			"  opacity: 0.6;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .contents {\n" + 
//			"  padding: 175px 0px 120px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .contents h5 {\n" + 
//			"  font-size: 50px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .contents .head-title {\n" + 
//			"  color: #fff;\n" + 
//			"  font-size: 80px;\n" + 
//			"  letter-spacing: 10px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  font-weight: 700;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .contents p {\n" + 
//			"  font-size: 30px;\n" + 
//			"  color: #fff;\n" + 
//			"  font-weight: 400;\n" + 
//			"  line-height: 30px;\n" + 
//			"  margin-bottom: 25px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .contents .btn {\n" + 
//			"  margin: 25px 0px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .banner_bottom_btn {\n" + 
//			"  margin-top: 40px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .banner_bottom_btn i {\n" + 
//			"  color: #fff;\n" + 
//			"  font-size: 48px;\n" + 
//			"  -webkit-transition: all 0.2s linear;\n" + 
//			"  -moz-transition: all 0.2s linear;\n" + 
//			"  -o-transition: all 0.2s linear;\n" + 
//			"  transition: all 0.2s linear;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#hero-area .banner_bottom_btn i:hover {\n" + 
//			"  color: #ddd;\n" + 
//			"}\n" + 
//			"\n" + 
//			"/* ==========================================================================\n" + 
//			"  Portfolio Section\n" + 
//			"   ========================================================================== */\n" + 
//			"#portfolios {\n" + 
//			"  background: #f2f2f2;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#portfolios .mix {\n" + 
//			"  padding: 10px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#portfolios .portfolio-item .shot-item {\n" + 
//			"  margin: 0px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#portfolio .mix {\n" + 
//			"  display: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			".controls {\n" + 
//			"  text-align: center;\n" + 
//			"  padding: 0px 0px 20px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".controls .active {\n" + 
//			"  color: #00b4d9 !important;\n" + 
//			"  border-color: #00b4d9;\n" + 
//			"  background: transparent;\n" + 
//			"}\n" + 
//			"\n" + 
//			".controls .btn {\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  margin: 2px;\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".controls:hover {\n" + 
//			"  cursor: pointer;\n" + 
//			"}\n" + 
//			"\n" + 
//			".portfolio-img {\n" + 
//			"  overflow: hidden;\n" + 
//			"  display: block;\n" + 
//			"  position: relative;\n" + 
//			"}\n" + 
//			"\n" + 
//			".portfolio-img img {\n" + 
//			"  width: 100%;\n" + 
//			"}\n" + 
//			"\n" + 
//			".shot-item {\n" + 
//			"  margin-right: 15px;\n" + 
//			"  border-radius: 4px;\n" + 
//			"  background: #fff;\n" + 
//			"  position: relative;\n" + 
//			"}\n" + 
//			"\n" + 
//			".shot-item img {\n" + 
//			"  width: 100%;\n" + 
//			"}\n" + 
//			"\n" + 
//			".shot-item .overlay {\n" + 
//			"  position: absolute;\n" + 
//			"  width: 100%;\n" + 
//			"  height: 100%;\n" + 
//			"  left: 0;\n" + 
//			"  top: 0;\n" + 
//			"  background: rgba(0, 180, 217, 0.6);\n" + 
//			"  opacity: 0;\n" + 
//			"  -webkit-transition: all 0.5s ease-in-out;\n" + 
//			"  transition: all 0.5s ease-in-out;\n" + 
//			"}\n" + 
//			"\n" + 
//			".shot-item:hover .overlay {\n" + 
//			"  opacity: 1;\n" + 
//			"}\n" + 
//			"\n" + 
//			".overlay {\n" + 
//			"  opacity: 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			".overlay .icons i {\n" + 
//			"  height: 42px;\n" + 
//			"  width: 42px;\n" + 
//			"  line-height: 42px;\n" + 
//			"  color: #00b4d9;\n" + 
//			"  left: 50%;\n" + 
//			"  margin-left: -24px;\n" + 
//			"  margin-top: -24px;\n" + 
//			"  top: 50%;\n" + 
//			"  position: absolute;\n" + 
//			"  z-index: 2;\n" + 
//			"  cursor: pointer;\n" + 
//			"  text-align: center;\n" + 
//			"  font-size: 20px;\n" + 
//			"  -webkit-transition: all 0.5s ease-in-out;\n" + 
//			"  -moz-transition: all 0.5s ease-in-out;\n" + 
//			"  transition: all 0.5s ease-in-out;\n" + 
//			"  background: #fff;\n" + 
//			"  border-radius: 4px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".overlay .preview {\n" + 
//			"  position: absolute;\n" + 
//			"  left: 45%;\n" + 
//			"  top: 50%;\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".overlay .link {\n" + 
//			"  position: absolute;\n" + 
//			"  left: 60%;\n" + 
//			"  margin-left: 10px;\n" + 
//			"  top: 50%;\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".shot-item:hover .overlay {\n" + 
//			"  opacity: 1;\n" + 
//			"}\n" + 
//			"\n" + 
//			"a:not([href]):not([tabindex]) {\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			"a:not([href]):not([tabindex]):focus, a:not([href]):not([tabindex]):hover {\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			"/* Services Item */\n" + 
//			".services {\n" + 
//			"  background: #F0F0F0;\n" + 
//			"}\n" + 
//			"\n" + 
//			".services-item {\n" + 
//			"  background: #fff;\n" + 
//			"  border-radius: 4px;\n" + 
//			"  padding: 48px 20px;\n" + 
//			"  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);\n" + 
//			"  text-align: center;\n" + 
//			"  transition: all 0.3s ease-in-out 0s;\n" + 
//			"  -moz-transition: all 0.3s ease-in-out 0s;\n" + 
//			"  -webkit-transition: all 0.3s ease-in-out 0s;\n" + 
//			"  -o-transition: all 0.3s ease-in-out 0s;\n" + 
//			"}\n" + 
//			"\n" + 
//			".services-item .icon i {\n" + 
//			"  font-size: 42px;\n" + 
//			"  margin-bottom: 15px;\n" + 
//			"  text-align: center;\n" + 
//			"  width: 48px;\n" + 
//			"  display: block;\n" + 
//			"  margin: 0 auto;\n" + 
//			"  height: 48px;\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".services-item .services-content h3 {\n" + 
//			"  margin-top: 10px;\n" + 
//			"  margin-bottom: 10px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".services-item .services-content h3 a {\n" + 
//			"  font-size: 18px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"  color: #666;\n" + 
//			"}\n" + 
//			"\n" + 
//			".services-item .services-content h3 a:hover {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".services-item .services-content p {\n" + 
//			"  line-height: 22px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".services-item:hover {\n" + 
//			"  box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.2);\n" + 
//			"}\n" + 
//			"\n" + 
//			".form-control {\n" + 
//			"  width: 100%;\n" + 
//			"  margin-bottom: 20px;\n" + 
//			"  font-size: 14px;\n" + 
//			"  border-radius: 0;\n" + 
//			"  -webkit-transition: all 0.3s;\n" + 
//			"  -moz-transition: all 0.3s;\n" + 
//			"  transition: all 0.3s;\n" + 
//			"  padding: 8px 10px;\n" + 
//			"  border: 1px solid #e1e1e1;\n" + 
//			"}\n" + 
//			"\n" + 
//			".form-control:focus {\n" + 
//			"  box-shadow: none;\n" + 
//			"  outline: none;\n" + 
//			"}\n" + 
//			"\n" + 
//			".btn.disabled, .btn:disabled {\n" + 
//			"  opacity: 1;\n" + 
//			"}\n" + 
//			"\n" + 
//			".contact-form-area {\n" + 
//			"  background: #fff;\n" + 
//			"  box-shadow: 0 0 30px #ededed;\n" + 
//			"  padding: 60px 40px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".contact-form-area h2 {\n" + 
//			"  font-size: 18px;\n" + 
//			"  text-transform: uppercase;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-right-contact {\n" + 
//			"  padding: 4px;\n" + 
//			"  border: 1px solid #e1e1e1;\n" + 
//			"  margin-top: 30px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-right-contact .single-contact {\n" + 
//			"  margin: 10px 22px;\n" + 
//			"  padding: 3px 55px;\n" + 
//			"  position: relative;\n" + 
//			"  color: #666;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-right-contact .single-contact p {\n" + 
//			"  margin-bottom: 5px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-right-contact .single-contact p a {\n" + 
//			"  color: #666;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-right-contact .contact-icon {\n" + 
//			"  background: #00b4d9;\n" + 
//			"  color: #fff;\n" + 
//			"  border-radius: 50%;\n" + 
//			"  font-size: 20px;\n" + 
//			"  height: 40px;\n" + 
//			"  left: 0;\n" + 
//			"  padding-top: 8px;\n" + 
//			"  position: absolute;\n" + 
//			"  text-align: center;\n" + 
//			"  top: 50%;\n" + 
//			"  -webkit-transform: translateY(-50%);\n" + 
//			"  transform: translateY(-50%);\n" + 
//			"  width: 40px;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#contact {\n" + 
//			"  position: relative;\n" + 
//			"  overflow: hidden;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#contact #contactForm {\n" + 
//			"  margin-top: 30px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".text-danger {\n" + 
//			"  font-size: 14px;\n" + 
//			"  margin-top: 10px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".list-unstyled li {\n" + 
//			"  color: #d9534f;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#conatiner-map {\n" + 
//			"  margin-top: 30px;\n" + 
//			"  text-align: center;\n" + 
//			"  background-color: #fff;\n" + 
//			"  height: 370px;\n" + 
//			"  -webkit-transition: all 0.3s;\n" + 
//			"  -moz-transition: all 0.3s;\n" + 
//			"  transition: all 0.3s;\n" + 
//			"  z-index: 101;\n" + 
//			"  width: 100%;\n" + 
//			"}\n" + 
//			"\n" + 
//			"/* Footer Area Start */\n" + 
//			".footer-area {\n" + 
//			"  background: #1C1C20;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-area .footer-text p {\n" + 
//			"  font-size: 14px;\n" + 
//			"  margin-top: 20px;\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-area .footer-text p a {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-area .footer-text .nav-inline .nav-link {\n" + 
//			"  padding: 11px 7px;\n" + 
//			"  color: #888;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-area .footer-text .nav-inline .nav-link:hover {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-2 {\n" + 
//			"  background: #252525;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-2 img {\n" + 
//			"  margin-top: -8px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-2 h3 {\n" + 
//			"  font-size: 20px;\n" + 
//			"  color: #fff;\n" + 
//			"  font-weight: 700;\n" + 
//			"  padding-bottom: 10px;\n" + 
//			"  letter-spacing: 0.5px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-2 p {\n" + 
//			"  font-size: 14px;\n" + 
//			"  color: #fff;\n" + 
//			"  line-height: 20px;\n" + 
//			"  margin: 0;\n" + 
//			"  padding-right: 50px;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-2 ul li a {\n" + 
//			"  color: #fff;\n" + 
//			"  font-size: 13px;\n" + 
//			"  font-weight: 400;\n" + 
//			"}\n" + 
//			"\n" + 
//			".footer-2 ul li a:hover {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#copyright {\n" + 
//			"  background: #333;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#copyright p {\n" + 
//			"  line-height: 42px;\n" + 
//			"  color: #fff;\n" + 
//			"  margin: 0;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#copyright p a {\n" + 
//			"  color: #fff;\n" + 
//			"}\n" + 
//			"\n" + 
//			"#copyright p a:hover {\n" + 
//			"  color: #00b4d9;\n" + 
//			"}\n" + 
//			"\n" + 
//			"      </style>\n" + 
//			"  \n" + 
//			"  </head>\n" + 
//			"  <body>\n" + 
//			"\n" + 
//			"    <!-- Header Area wrapper Starts -->\n" + 
//			"    <header id=\"header-wrap\">\n" + 
//			"\n" + 
//			"    </header>\n" + 
//			"    <!-- Header Area wrapper End -->\n" + 
//			"\n" + 
//			"    <!-- About Section Start -->\n" + 
//			"    <section id=\"about\" class=\"section-padding\">\n" + 
//			"      <div class=\"container\">\n" + 
//			"        <div class=\"row\">\n" + 
//			"          <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\n" + 
//			"            <div class=\"img-thumb wow fadeInLeft\" data-wow-delay=\"0.3s\">\n" + 
//			"              <img class=\"img-fluid\" src=\"assets/img/about/about-1.jpg\" alt=\"\">\n" + 
//			"            </div>\n" + 
//			"          </div> \n" + 
//			"          <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\">\n" + 
//			"            <div class=\"profile-wrapper wow fadeInRight\" data-wow-delay=\"0.3s\">\n" + 
//			"              <h3>Hi Guys!</h3>\n" + 
//			"              <p>Est diam venenatis arcu lacus ad. Duis quis eros. Cursus et rutrum eleifend sollicitudin lacinia justo id turpis. Nec convallis integer. Odio eget duis. Nulla aenean et. Blandit varius sollicitudin. Pellentesque leo primis neque urna magnis. Elit ut sollicitudin. Et est a nam dolores eget itaque sagittis et parturient duis est eleifend sociis rutrum odio viverra integer.</p>\n" + 
//			"              <div class=\"about-profile\">\n" + 
//			"                <ul class=\"admin-profile\">\n" + 
//			"                  <li><span class=\"pro-title\"> Name </span> <span class=\"pro-detail\">"+names+"</span></li>\n" + 
//			"                  <li><span class=\"pro-title\"> Country </span> <span class=\"pro-detail\">KENYA</span></li>\n" + 
//			"                  <li><span class=\"pro-title\"> Location </span> <span class=\"pro-detail\">"+location+"</span></li>\n" + 
//			"                  <li><span class=\"pro-title\"> e-mail </span> <span class=\"pro-detail\">"+emailAdress+"</span></li>\n" + 
//			"                  <li><span class=\"pro-title\"> Phone </span> <span class=\"pro-detail\">"+phoneNumber+"</span></li>\n" + 
//			"                </ul>\n" + 
//			"              </div>\n" + 
//			"              <a href=\"#\" class=\"btn btn-common\"><i class=\"icon-paper-clip\"></i>ACCEPT</a>\n" + 
//			"              <a href=\"#\" class=\"btn btn-danger\"><i class=\"icon-speech\"></i> DECLINE</a>\n" + 
//			"            </div>\n" + 
//			"          </div>   \n" + 
//			"        </div>\n" + 
//			"      </div>\n" + 
//			"    </section>\n" + 
//			"    <!-- About Section End -->\n" + 
//			"    <!-- Footer Section End -->\n" + 
//			"   </body>\n" + 
//			"</html>\n" + 
//			"";
	
	}
}

