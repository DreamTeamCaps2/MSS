$(function() {

  $.validator.setDefaults({
    errorClass: 'help-block',
    highlight: function(element) {
      $(element)
        .closest('.form-group')
        .addClass('has-error');
    },
    unhighlight: function(element) {
      $(element)
        .closest('.form-group')
        .removeClass('has-error');
    },
    errorPlacement: function (error, element) {
      if (element.prop('type') === 'checkbox') {
        error.insertAfter(element.parent());
      } else {
        error.insertAfter(element);
      }
    }
  });

  $.validator.addMethod('strongPassword', function(value, element) {
    return this.optional(element) 
      || value.length >= 6
      && /\d/.test(value)
      && /[a-z]/i.test(value);
  }, 'Your password must be at least 6 characters long and contain at least one number and one char\'.')

  
  $("#changePass-form").validate({
	 rules:{
		 matKhau: {
	          required: true,
	          remote: {
	          	url:"/MSS/doi-mat-khau.do",
	          	type:"post",
	          	data:{
	          		success: function(response){  
	  			    	if(response==false){
	  			    		false;
	  			    	}
	  			    	else {
	  			    		true;
	  			    	}
	  			    }
	          	}
	          }
	     },
		 matKhauNew: {
	          required: true,
	          strongPassword: true
	     },
	     matKhau2: {
	          required: true,
	          equalTo: '#password'
	     }
	 },
	     messages: {
	    	 matKhau: {
	           required: 'Please enter old password.',
	           remote: 'Sai Mat khau'
	         }
	     }
  });
  
  
  $("#register-form").validate({
    rules: {
      email: {
        required: true,
        email: true,
        remote: {
        	url:"/MSS/dangKyTK.do",
        	type:"post",
        	data:{
        		success: function(response){  
			    	if(response==false){
			    		false;
			    	}
			    	else {
			    		true;
			    	}
			    }
        	}
        }
      },
      matKhau: {
          required: true,
          strongPassword: true
      },
      matKhau2: {
          required: true,
          equalTo: '#password'
      },
      tenDangNhap: {
        required: true,
        nowhitespace: true,
        remote: {
        	url:"/MSS/dangKyTK.do",
        	type:"post",
        	data:{
        		success: function(response){  
			    	if(response==false){
			    		false;
			    	}
			    	else {
			    		true;
			    	}
			    }
        	}
        }
      },
      SDT: {
        digits: true,
        minlength: 10,
        maxlength: 11
      },
      diaChi: {
      },
      terms: {
        required: true
      },
      tenNhaThuoc: {
          required: true
      },
      tenPhongKham: {
    	  required: true
      }
    },
    messages: {
      email: {
        required: 'Please enter an email address.',
        email: 'Please enter a <em>valid</em> email address.',
        remote: 'This email exist'
      },
      tenDangNhap: {
          required: 'This field is required.',
          tenDangNhap: 'No white space please.',
          remote: 'This username exist'
        }      
    }
  });

});