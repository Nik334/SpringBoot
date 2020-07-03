<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="https://bryanrojasq.wordpress.com">
                <img src="http://placehold.it/200x50&text=LOGO" alt="LOGO">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
                </a>
            </li>            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Recruiter(Admin) <b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                    <li><a href="#"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="#" data-toggle="collapse" data-target="#submenu-1"><i class="fa fa-fw fa-search"></i> Job <i class="fa fa-fw fa-angle-down pull-right"></i></a>
                    <ul id="submenu-1" class="collapse">
                        <li><a href="../../admin/addJob"><i class="fa fa-plus"></i> ADD JOB</a></li>
                        <li><a href="../../admin/editJob"><i class="fa fa-pencil"></i> EDIT JOB</a></li>
                        <li><a href="../../admin/deleteJob"><i class="fa fa-trash"></i> DELETE JOB</a></li>
                    </ul>
                </li>
                <li>
                    <a href="../../admin/addJob"><i class="fa fa-fw fa-plus"></i>  Create Job</a>
                </li>
                <li>
                    <a href="../../admin/assigningCandidate"><i class="fa fa-fw fa-gavel"></i> Assign candidate to the job</a>
                </li>
                <li>
                    <a href="faq"><i class="fa fa-fw fa fa-user-plus"></i> Add Recruiter (Visitor)</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    
    <!-- /#page-wrapper -->