<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="/finder" id="navbarDropdown1" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Finder
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item text-secondary" href="/findExhibitsByWorkerName">
                            Exhibits By Worker Name</a>
                        <a class="dropdown-item text-secondary" href="/findExhibitsByAuthor">
                            Exhibits By Author</a>
                        <a class="dropdown-item text-secondary" href="/findExhibitsByRoom">
                            Exhibits By Room</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="/stat" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Statistic
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item text-secondary" href="/stat">All statistics</a>
                        <div class="dropdown-divider text-white"></div>
                        <a class="dropdown-item text-secondary" href="/statByTechnique">By Technique</a>
                        <a class="dropdown-item text-secondary" href="/statByMaterial">By Material</a>
                        <a class="dropdown-item text-secondary" href="/statByTourguides">By Tourguides</a>
                        <div class="dropdown-divider text-white"></div>
                        <a class="dropdown-item text-secondary"
                           href="${pageContext.request.contextPath}/pages/totalWorkingTimeTourguide.jsp">By Total
                            Working
                            Time</a>
                        <a class="dropdown-item text-secondary" href="/statByCountOfExcursions">By Count Of
                            Excursions</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="/excursions">Excursions</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="/tourguides" id="tour" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Tourguides
                    </a>
                    <div class="dropdown-menu" aria-labelledby="tour">
                        <a class="dropdown-item text-secondary" href="/tourguides">All Tourguides</a>

                        <div class="dropdown-divider text-white"></div>

                        <a class="dropdown-item text-secondary" href="/freeTourguides">Get free tourguides</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>