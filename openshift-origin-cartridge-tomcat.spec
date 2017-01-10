%global cartridgedir %{_libexecdir}/openshift/cartridges/tomcat7

Summary:       Tomcat7 cartridge
Name:          openshift-origin-cartridge-tomcat
Version: 1.0.0
Release:       1%{?dist}
Group:         Development/Languages
License:       ASL 2.0
URL:           https://www.openshift.com
Source0:       http://mirror.openshift.com/pub/openshift-origin/source/%{name}/%{name}-%{version}.tar.gz
Requires:      openshift-origin-node-util
Provides:      openshift-origin-cartridge-tomcat = 1.0.0
BuildArch:     noarch

%description
Tomcat7 cartridge for openshift. (Cartridge Format V2)

%prep
%setup -q

%build
%__rm %{name}.spec
%__rm hooks/.gitkeep

%install
%__mkdir -p %{buildroot}%{cartridgedir}
%__cp -r * %{buildroot}%{cartridgedir}

%files
%dir %{cartridgedir}
%attr(0755,-,-) %{cartridgedir}/bin/
%attr(0755,-,-) %{cartridgedir}/hooks/
%{cartridgedir}/configuration
%{cartridgedir}/metadata
%{cartridgedir}/usr
%{cartridgedir}/env
%doc %{cartridgedir}/README.md
%doc %{cartridgedir}/COPYRIGHT
%doc %{cartridgedir}/LICENSE

%changelog
* Fri Nov 05 2014 Andrea Lora <somashis.nath@gmail.com> 1.0.0
- First implementation (somashis.nath@gmail.com)
