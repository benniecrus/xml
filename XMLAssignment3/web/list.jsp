<%-- 
    Document   : index
    Created on : Mar 22, 2017, 8:54:49 PM
    Author     : Nam NV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
		<title>Timber</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
		<link rel='stylesheet' id='camera-css'  href='css/camera.css' type='text/css' media='all'>

		<link rel="stylesheet" type="text/css" href="css/slicknav.css">
		<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet" charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		
		
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

		<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700|Open+Sans:700' rel='stylesheet' type='text/css'>
		<script type="text/javascript" src="js/jquery.mobile.customized.min.js"></script>
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 
		<script type="text/javascript" src="js/camera.min.js"></script>
		<script type="text/javascript" src="js/myscript.js"></script>
		<script src="js/sorting.js" type="text/javascript"></script>
		<script src="js/jquery.isotope.js" type="text/javascript"></script>
		<!--script type="text/javascript" src="js/jquery.nav.js"></script-->
		

		<script>
			jQuery(function(){
					jQuery('#camera_wrap_1').camera({
					transPeriod: 500,
					time: 3000,
					height: '490px',
					thumbnails: false,
					pagination: true,
					playPause: false,
					loader: false,
					navigation: false,
					hover: false
				});
			});
		</script>
		
	</head>
	<body>
    
    <!--home start-->
    
    <div id="home">
    	<div class="headerLine">
	<div id="menuF" class="default">
		<div class="container">
			<div class="row">
				<div class="logo col-md-4">
				</div>
				<div class="col-md-8">
					<div class="navmenu"style="text-align: center;">
						<ul id="menu">
							<li class="active" ><a href="#home">Trang chủ</a></li>
                                                        <li><a href="#project">Danh mục</a></li>
							<li><a href="#news">Tin mới</a></li>
							<li class="last"><a href="#contact">Liên hệ</a></li>
							<!--li><a href="#features">Features</a></li-->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="container">
			<div class="row wrap">
				<div class="col-md-12 gallery"> 
						<div class="camera_wrap camera_white_skin" id="camera_wrap_1">
							<div data-thumb="" data-src="images/slides/blank.gif">
								<div class="img-responsive camera_caption fadeFromBottom">
									<h2>Làm đẹp.</h2>
								</div>
							</div>
							<div data-thumb="" data-src="images/slides/blank.gif">
								<div class="img-responsive camera_caption fadeFromBottom">
									<h2>Thời trang.</h2>
								</div>
							</div>
							<div data-thumb="" data-src="images/slides/blank.gif">
								<div class="img-responsive camera_caption fadeFromBottom">
									<h2>Sức khỏe đời sống.</h2>
								</div>
							</div>
						</div><!-- #camera_wrap_1 -->
				</div>
			</div>
		</div>
	</div>
		   
    </div>
    
    <!--about start-->    
    
    
    
    <!--project start-->    
    
    <div id="project">     
    
    
       <div class="container">
		
		<div class="row">
			<!-- filter_block -->
				<div id="options" class="col-md-12" style="text-align: center;">	
					<ul id="filter" class="option-set" data-option-key="filter">
						<li><a class="selected" href="#filter" data-option-value="*" class="current">Tất cả</a></li>
                                                <li><a href="#filter" data-option-value=".polygraphy">Làm đẹp</a></li>
						<li><a href="#filter" data-option-value=".branding">Thời trang</a></li>
						<li><a href="#filter" data-option-value=".web">Sức khỏe đời sống</a></li>
					</ul>
				</div><!-- //filter_block -->
		
		
                        <div class="portfolio_block columns3   pretty" data-animated="fadeIn">
                            
                            <c:forEach items="${listMakeup}" var = "p">
                                        <div class="element col-sm-4   gall polygraphy">
                                            <a class="plS" href="${p.link}" target="_blank">
							<img class="img-responsive picsGall" src="${p.imgSource}"/>
						</a>
						<div class="view project_descr ">
							<h3><a href="${p.link}">${p.title}</a></h3>
							
						</div>
					</div>
                            </c:forEach>
                         		
                            <c:forEach items="${listFashion}" var = "p">
                                        <div class="element col-sm-4   gall branding">
                                            <a class="plS" href="${p.link}" target="_blank">
							<img class="img-responsive picsGall" src="${p.imgSource}"/>
						</a>
						<div class="view project_descr ">
							<h3><a href="${p.link}">${p.title}</a></h3>
							
						</div>
					</div>
                            </c:forEach>
                            
                            <c:forEach items="${listHealth}" var = "p">
                                        <div class="element col-sm-4   gall web">
                                            <a class="plS" href="${p.link}" target="_blank">
							<img class="img-responsive picsGall" src="${p.imgSource}"/>
						</a>
                                                <div class="view project_descr ">
							<h3><a href="${p.link}">${p.title}</a></h3>
							
						</div>
					</div>
                            </c:forEach>
                            
			</div>
                </div>
                                
			
                                
                             
			
			
				
					
			
		
			
			<script type="text/javascript">
				jQuery(window).load(function(){
					items_set = [
					
						{category : 'branding', lika_count : '77', view_count : '234', src : 'images/prettyPhotoImages/pic9.jpg', title : 'Foil Mini Badges', content : '' },
						
						{category : 'polygraphy', lika_count : '45', view_count : '100', src : 'images/prettyPhotoImages/pic7.jpg', title : 'Darko – Business Card Mock Up', content : '' },
						
						{category : 'text_styles', lika_count : '22', view_count : '140', src : 'images/prettyPhotoImages/pic8.jpg', title : 'Woody Poster Text Effect', content : '' }
						

					];
					jQuery('.portfolio_block').portfolio_addon({
						type : 1, // 2-4 columns simple portfolio
						load_count : 3,
						
						items : items_set
					});
					$('#container').isotope({
					  animationOptions: {
						 duration: 900,
						 queue: false
					   }
					});
				});
			</script>
		</div>
    </div> 
    
    <!--news start-->
    
    <div id="news">
    	<div class="line4">		
			<div class="container">
				<div class="row Ama">
					<div class="col-md-12">
					<h3>What&rsquo;s New?</h3>
					<p>Get the latest news from our blog</p>
					</div>
				</div>
			</div>
		</div>
		
                    
                    <c:forEach items="${listNews}" var = "p">
                        <%int i = 0; 
                        if(i%2==0) { %>
                        <div class="container">
                            <div class="row news">
                                        <div class="col-md-6  text-left">
                                            <img class="img-responsive picsGall" src="${p.imgSource}"/>
                                            <h3><a href="${p.link}">${p.title}</a></h3>
                                            <p align="center">${p.pubDate}</p>
                                            <p>${p.description}</p>
                                            <hr class="hrNews">
					</div>
                                    <% } else { %>
                                    <div class="col-md-6  text-right">
                                            <img class="img-responsive picsGall" src="${p.imgSource}"/>
                                            <h3><a href="${p.link}">${p.title}</a></h3>
                                            <p align="center">${p.pubDate}</p>
                                            <p>${p.description}</p>
					</div>
                                        </div>
                        </div>
                                        <% } %>
                            
                            </c:forEach>
                    
				
    </div>
    <!--contact start-->
    
    <div id="contact">
    	<div class="line5">					
			<div class="container">
				<div class="row Ama">
					<div class="col-md-12">
					<h3>Got a Question? We&rsquo;re Here to Help!</h3>
					<p>Get in touch with us</p>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-9 col-xs-12 forma">
					<form>
						<input type="text" class="col-md-6 col-xs-12 name" name='name' placeholder='Name *'/>
						<input type="text" class="col-md-6 col-xs-12 Email" name='Email' placeholder='Email *'/>
						<input type="text" class="col-md-12 col-xs-12 Subject" name='Subject' placeholder='Subject'/>
						<textarea type="text" class="col-md-12 col-xs-12 Message" name='Message' placeholder='Message *'></textarea>
						<div class="cBtn col-xs-12">
							<ul>
								<li class="clear"><a href="#"><i class="fa fa-times"></i>clear form</a></li>
								<li class="send"><a href="#"><i class="fa fa-share"></i>Send Message</a></li>
							</ul>
						</div>
					</form>
				</div>
				<div class="col-md-3 col-xs-12 cont">
					<ul>
						<li><i class="fa fa-home"></i>5512 Lorem Ipsum Vestibulum 666/13</li>
						<li><i class="fa fa-phone"></i>+1 800 789 50 12, +1 800 450 6935</li>
						<li><a href="#"><i class="fa fa-envelope"></i>mail@compname.com</a></li>
						<li><i class="fa fa-skype"></i>compname</li>
						<li><a href="#"><i class="fa fa-twitter"></i>Twitter</a></li>
						<li><a href="#"><i class="fa fa-facebook-square"></i>Facebook</a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i>Dribbble</a></li>
						<li><a href="#"><i class="fa fa-flickr"></i>Flickr</a></li>
						<li><a href="#"><i class="fa fa-youtube-play"></i>YouTube</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="line7">
			<div class="container">
				<div class="row footer">
					<div class="col-md-12">
						<h3>Subscribe for Our Newsletter!</h3>
						<p>Subscribe to our newsletter email to get notification about fresh news, latest promos, giveaways and free stuff from Skew. Stay always up-to-date!</p>
						<div class="fr">
						<div style="display: inline-block;">
							<input class="col-md-6 fEmail" name='Email' placeholder='Enter Your Email'/>
							<a href="#" class="subS">Subscribe!</a>
						</div>
						</div>
					</div>
					<div class="soc col-md-12">
						<ul>
							<li class="soc1"><a href="#"></a></li>
							<li class="soc2"><a href="#"></a></li>
							<li class="soc3"><a href="#"></a></li>
							<li class="soc4"><a href="#"></a></li>
							<li class="soc5"><a href="#"></a></li>
							<li class="soc6"><a href="#"></a></li>
							<li class="soc7"><a href="#"></a></li>
							<li class="soc8"><a href="#"></a></li>
							
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="lineBlack">
			<div class="container">
				<div class="row downLine">
					<div class="col-md-12 text-right">
						<!--input  id="searchPattern" type="search" name="pattern" value="Search the Site" onblur="if(this.value=='') {this.value='Search the Site'; }" onfocus="if(this.value =='Search the Site' ) this.value='';this.style.fontStyle='normal';" style="font-style: normal;"/-->
						<input  id="searchPattern" type="search" placeholder="Search the Site"/><i class="glyphicon glyphicon-search" style="font-size: 13px; color:#a5a5a5;" id="iS"></i>
					</div>
					<div class="col-md-6 text-left copy">
						<p>Copyright &copy; 2014 Timber HTML Template. All Rights Reserved.</p>
					</div>
					<div class="col-md-6 text-right dm">
						<ul id="downMenu">
							<li class="active"><a href="#home">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#project1">Projects</a></li>
							<li><a href="#news">News</a></li>
							<li class="last"><a href="#contact">Contact</a></li>
							<!--li><a href="#features">Features</a></li-->
						</ul>
					</div>
				</div>
			</div>
		</div>
    </div>		
		
		
	<script src="js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script>
			$(document).ready(function(){
			$(".bhide").click(function(){
				$(".hideObj").slideDown();
				$(this).hide(); //.attr()
				return false;
			});
			$(".bhide2").click(function(){
				$(".container.hideObj2").slideDown();
				$(this).hide(); // .attr()
				return false;
			});
				
			$('.heart').mouseover(function(){
					$(this).find('i').removeClass('fa-heart-o').addClass('fa-heart');
				}).mouseout(function(){
					$(this).find('i').removeClass('fa-heart').addClass('fa-heart-o');
				});
				
				function sdf_FTS(_number,_decimal,_separator)
				{
				var decimal=(typeof(_decimal)!='undefined')?_decimal:2;
				var separator=(typeof(_separator)!='undefined')?_separator:'';
				var r=parseFloat(_number)
				var exp10=Math.pow(10,decimal);
				r=Math.round(r*exp10)/exp10;
				rr=Number(r).toFixed(decimal).toString().split('.');
				b=rr[0].replace(/(\d{1,3}(?=(\d{3})+(?:\.\d|\b)))/g,"\$1"+separator);
				r=(rr[1]?b+'.'+rr[1]:b);

				return r;
}
				
			setTimeout(function(){
					$('#counter').text('0');
					$('#counter1').text('0');
					$('#counter2').text('0');
					setInterval(function(){
						
						var curval=parseInt($('#counter').text());
						var curval1=parseInt($('#counter1').text().replace(' ',''));
						var curval2=parseInt($('#counter2').text());
						if(curval<=707){
							$('#counter').text(curval+1);
						}
						if(curval1<=12280){
							$('#counter1').text(sdf_FTS((curval1+20),0,' '));
						}
						if(curval2<=245){
							$('#counter2').text(curval2+1);
						}
					}, 2);
					
				}, 500);
			});
	</script>
	<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery('#menu').slicknav();
		
	});
	</script>
	
	<script type="text/javascript">
    $(document).ready(function(){
       
        var $menu = $("#menuF");
            
        $(window).scroll(function(){
            if ( $(this).scrollTop() > 100 && $menu.hasClass("default") ){
                $menu.fadeOut('fast',function(){
                    $(this).removeClass("default")
                           .addClass("fixed transbg")
                           .fadeIn('fast');
                });
            } else if($(this).scrollTop() <= 100 && $menu.hasClass("fixed")) {
                $menu.fadeOut('fast',function(){
                    $(this).removeClass("fixed transbg")
                           .addClass("default")
                           .fadeIn('fast');
                });
            }
        });
	});
    //jQuery
	</script>
	<script>
		/*menu*/
		function calculateScroll() {
			var contentTop      =   [];
			var contentBottom   =   [];
			var winTop      =   $(window).scrollTop();
			var rangeTop    =   200;
			var rangeBottom =   500;
			$('.navmenu').find('a').each(function(){
				contentTop.push( $( $(this).attr('href') ).offset().top );
				contentBottom.push( $( $(this).attr('href') ).offset().top + $( $(this).attr('href') ).height() );
			})
			$.each( contentTop, function(i){
				if ( winTop > contentTop[i] - rangeTop && winTop < contentBottom[i] - rangeBottom ){
					$('.navmenu li')
					.removeClass('active')
					.eq(i).addClass('active');				
				}
			})
		};
		
		$(document).ready(function(){
			calculateScroll();
			$(window).scroll(function(event) {
				calculateScroll();
			});
			$('.navmenu ul li a').click(function() {  
				$('html, body').animate({scrollTop: $(this.hash).offset().top - 80}, 800);
				return false;
			});
		});		
	</script>	
	<script type="text/javascript" charset="utf-8">

		jQuery(document).ready(function(){
			jQuery(".pretty a[rel^='prettyPhoto']").prettyPhoto({animation_speed:'normal',theme:'light_square',slideshow:3000, autoplay_slideshow: true, social_tools: ''});
			
		});
	</script>
	</body>
	
</html>
