<script type='text/javascript' src='js/jquery-1.8.3.min.js'></script>
    <script type="text/javascript">
        <%   
           String msg =(String) session.getAttribute("msg");
        
        
        
        %>

        $(document).ready( function() {

        alert('<%=msg%>');
     

        });
        </script>
       
      