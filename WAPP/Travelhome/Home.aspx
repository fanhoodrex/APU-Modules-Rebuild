<%@ Page Title="" Language="C#" MasterPageFile="~/mp.master" AutoEventWireup="true" CodeFile="Home.aspx.cs" Inherits="Home" %>

<%-- 在此处添加内容控件 --%>
<asp:Content ID="Content1" runat="server" contentplaceholderid="ContentPlaceHolder1">
    <!-- banner -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1" class=""></li>
			<li data-target="#myCarousel" data-slide-to="2" class=""></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="container">
					<div class="carousel-caption">
						<h3>Japan <span>Fuji Mountain</span></h3>
					</div>
				</div>
			</div>
			<div class="item item2">
				<div class="container">
					<div class="carousel-caption">
						<h3>China<span>The Great Wall</span></h3>
					</div>
				</div>
			</div>
			<div class="item item3">
				<div class="container">
					<div class="carousel-caption">
						<h3>Malaysia<span>Petronas Twin Towers</span></h3>
					</div>
				</div>
			</div>
			
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="fa fa-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			<span class="fa fa-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
		<!-- The Modal -->
	</div>
	<!--//banner -->
<!--services-section-->
	<div class="services">
		<div class="container">
			<div class="wthree_head_section">
				<h3 class="w3l_header">Our <span>Services</span></h3>
				<p>More travel more insights</p>
			</div>
			<div class="advantages-grids">
				<div class="col-md-6  col-sm-6 col-xs-6 our-advantages-grid one">
					<div class="up-border">
						<div class="col-md-2 our-advantages-grd-left">
							<span class="fa fa-plane" aria-hidden="true"></span>
						</div>
						<div class="col-md-4 our-advantages-grd-right">
							<h4>Airline Tickets</h4>

						</div>
						<div class="col-md-6 our-advantages-grd-to-right">
							<p><span class="fa fa-long-arrow-right icons-left" aria-hidden="true"></span>Booking flights all the world </p>

							<p><span class="fa fa-long-arrow-right icons-left" aria-hidden="true"></span>Timely publishing ticket </p>
							
						</div>
						<div class="clearfix"> </div>
					</div>

				</div>
				<div class="col-md-6  col-sm-6 col-xs-6 our-advantages-grid two">
					<div class="up-border">
						<div class="col-md-2 our-advantages-grd-left">
							<span class="fa fa-building-o" aria-hidden="true"></span>
						</div>
						<div class="col-md-4 our-advantages-grd-right">
							<h4>Hotel Booking</h4>

						</div>
						<div class="col-md-6 our-advantages-grd-to-right">
							<p><span class="fa fa-long-arrow-right icons-left" aria-hidden="true"></span>More choices </p>

							<p><span class="fa fa-long-arrow-right icons-left" aria-hidden="true"></span>High Quality choice </p>
							
						</div>
						<div class="clearfix"> </div>
					</div>

				</div>
<div class="clearfix"> </div>
				<div class="col-md-6 col-sm-6 col-xs-6 our-advantages-grid three">
					<div class="up-border">
						<div class="col-md-2 our-advantages-grd-left">
							<span class="fa fa-bus" aria-hidden="true"></span>
						</div>
						<div class="col-md-4 our-advantages-grd-right">
							<h4>Train Tickets</h4>

						</div>
						<div class="col-md-6 our-advantages-grd-to-right">
							<p><span class="fa fa-long-arrow-right icons-left" aria-hidden="true"></span>Quick ticket purchase </p>

							<p><span class="fa fa-long-arrow-right icons-left" aria-hidden="true"></span>More offers </p>
							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-6 our-advantages-grid">
					<div class="up-border">
						<div class="col-md-2 our-advantages-grd-left">
							<span class="fa fa-globe" aria-hidden="true"></span>
						</div>
						<div class="col-md-4 our-advantages-grd-right">
							<h4>World Tour</h4>

						</div>
						<div class="col-md-6 our-advantages-grd-to-right">
							<p><span class="fa fa-long-arrow-right icons-left" aria-hidden="true"></span>Popular attractions in various countries </p>

							
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>

	<!-- testimonials -->
	<div class="testimonials">
	   <div class="test_agile_info">
		<div class="container">
			<ul id="flexiselDemo1">			
				<li>
					<div class="wthree_testimonials_grid_main">
						<div class="wthree_testimonials_grid">
							<h4>What Customer say</h4>
							<p>A good travel website that gives me a good guide.</p>
								<h5>Jack</h5>
							<div class="wthree_testimonials_grid_pos">
								<img src="images/t1.png" alt=" " class="img-responsive" />
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="wthree_testimonials_grid_main">
						<div class="wthree_testimonials_grid">
							<h4>What Customer say</h4>
							<p>I bought the plane ticket very quickly on this website. It lets me traveling on time.</p>
								<h5>Linda</h5>
							<div class="wthree_testimonials_grid_pos">
								<img src="images/t2.png" alt=" " class="img-responsive" />
							</div>
						</div>
					
					</div>
				</li>
				<li>
					<div class="wthree_testimonials_grid_main">
						<div class="wthree_testimonials_grid">
							<h4>What Customer say</h4>
							<p>I am very satisfied with the hotel which booked on this website.</p>
								<h5>Paul</h5>
							<div class="wthree_testimonials_grid_pos">
								<img src="images/t4.png" alt=" " class="img-responsive" />
							</div>
						</div>
						
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- //testimonials -->
</asp:Content>

