<div style='display:none'>
	<div class='contact-top'></div>
	<div class='contact-content'>
		<textarea name="fckContainer" id="fckContainer">
		</textarea>
	</div>
	<div class='contact-bottom'></div>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/fckeditor.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$.fck.config = {path: 'fckeditor/'};
			$('textarea#fckContainer').fck({height:220, width:455, toolbar:'Basic'});
		});			
	</script>	
</div>