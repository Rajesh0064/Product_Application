<!DOCTYPE html>
<html>
<head>
<title> add product </title>
<!-- bootstrap cdn link to get the  support of bootstrap-->
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="formvalidation.js"></script>
</head>
<body>
	  <div class="container mt-5 text-center">
		   <h2 class="text-center font-italic mb-1">save product data......</h2>
		   <form method="post" action="./UpdateProductServlet" enctype="multipart/form-data"  onsubmit="return validateForm()">
		     
       <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proId">Product ID</label>
		   <input type="text" class="form-control-sm" id="proId" name="proId" value="${existing.proId}" required><br>
       </div>
      
   <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proName">Product Name</label>
		   <input type="text" class="form-control-sm" id="proName" name="proName" value="${existing.proName}" required>
       </div>
   <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proPrice">Product Price</label>
		   <input type="text" class="form-control-sm" id="proPrice" name="proPrice" value="${existing.proPrice}"required>
       </div>

   <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proBrand">Product Brand</label>
		   <input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existing.proBrand}"required>
       </div>

   <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proMadeIn">made in</label>
		   <input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existing.proMadeIn}"required>
       </div>

   <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proMfgDate">MFG date </label>
		   <input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate" value="${existing.proMfgDate}"required>
       </div>

   <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proExpDate">Expiry date </label>
		   <input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value="${existing.proExpDate}"required>
       </div>

   <div class="form-group">
		   <label class="font-italic font-weight-bold" for="proImage">Product Image</label>
		   <input type="file" class="form-control-sm" id="proImage" name="proImage" value="${existing.proImage}">
       </div>
        
      <div>
		  <input type="submit" class="btn btn-success" value=" update product"/>
		  <a href="productlist.jsp" class="btn btn-primary"> List of Products</a>
 	  </div>
 	 	  
      </form>
    </div>
</body>
</html>