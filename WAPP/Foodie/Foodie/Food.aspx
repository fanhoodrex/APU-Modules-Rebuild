<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Food.aspx.cs" Inherits="Foodie.Food" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
    <asp:Panel ID="Panel1" runat="server">
        <p>
            View All</p>
        <p>
            <asp:Table ID="Table1" runat="server">
            </asp:Table>
        </p>
      
   <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />

                    <asp:DataList ID="DataList1" runat="server">

                            <ItemTemplate>
                                <div class="product-item accessories">
							<div class="product product_filter">

                                  
                                
                             
								<div class="product_image">
							<asp:Image ID="Image1" runat="server" ImageUrl='<%# "data:Image/png;base64,"+Convert .ToBase64String((byte [])Eval("productImage"))  %>'/>
								</div>
								<div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>sale</span></div>
								<div class="favorite favorite_left"></div>
								<div class="product_info"> 
									<h6 class="product_name"><a href="single.html"><%#Eval("productName") %></a></h6>
									<div class="product_price">  <%#Eval("productPrice") %></div>
								</div>
							</div>
							<div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
						</div>

                           
                              
                              
                                
                            </ItemTemplate>


                             </asp:DataList>
              



               

    </asp:Panel>
</asp:Content>
