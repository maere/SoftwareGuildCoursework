<!DOCTYPE html>
<!-- saved from url=(0050)http://getbootstrap.com/examples/starter-template/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">

        <title>Starter Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/starter-template.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body style="">

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://getbootstrap.com/examples/starter-template/#">Project name</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="http://getbootstrap.com/examples/starter-template/#">Home</a></li>
                        <li><a href="http://getbootstrap.com/examples/starter-template/#about">About</a></li>
                        <li><a href="http://getbootstrap.com/examples/starter-template/#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container">

            <div class="starter-template">
                <h1>I'm having a party and you are invited!</h1>
                Can you attend?</br>

                <form action="RSVPServlet" method="post"><!-- action selections the RSVP servlet class to handle requst -->
                <!-- this will resolve into the URL and stands for the URL we are going to post to -->
                
                Yes<input type="radio" name="myAnswer" value="Yes" checked />
                No <input type="radio" name="myAnswer" value="No" /><!--the two possible options for values we are sending  -->

                Reason (if not attending) <br />
                <select name="myReason">
                <!-- this is the *value* that gets sent to the server-->
                
                        <option value="Out of town">Out of Town</option> 
                        <option value="Schedule conflict">Schedule conflict</option>
                        <option value="You suck.">I don't like you</option>
                </select></br>
                
                <!--this will also possibly be included whte post -->
                        Notes: <br />
                        <input type="text" name="myNotes" /><br /><!--the text value of myNotes is what will be sent -->
                        <input type="submit" value="RSVP" /> <!--this is what the submit button says on it -->
                </form>
            </div>



        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


    </body></html>