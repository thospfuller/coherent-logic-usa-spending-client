package com.coherentlogic.usaspending.client.core.builders;

/**

 *
country code     country name
AC     Antigua and Barbuda
AF     Afghanistan
AG     Algeria
AJ     Azerbaijan
AL     Albania
AM     Armenia
AN     Andorra
AO     Angola
AR     Argentina
AS     Australia
AU     Austria
BA     Bahrain
BB     Barbados
BC     Botswana
BE     Belgium
BF     Bahamas, The
BG     Bangladesh
BH     Belize
BK     Bosnia and Herzegovina
BL     Bolivia
BM     Burma
BN     Benin
BO     Belarus
BP     Solomon Islands
BR     Brazil
BT     Bhutan
BU     Bulgaria
BX     Brunei
BY     Burundi
CA     Canada
CB     Cambodia
CD     Chad
CE     Sri Lanka
CF     Congo (Brazzaville)
CG     Congo (Kinshasa)
CH     China
CI     Chile
CM     Cameroon
CN     Comoros
CO     Colombia
CS     Costa Rica
CT     Central African Republic
CU     Cuba
CV     Cape Verde
CY     Cyprus
DA     Denmark
DJ     Djibouti
DO     Dominica
DR     Dominican Republic
EC     Ecuador
EG     Egypt
EI     Ireland
EK     Equatorial Guinea
EN     Estonia
ER     Eritrea
ES     El Salvador
ET     Ethiopia
EZ     Czech Republic
FI     Finland
FJ     Fiji
FM     Micronesia
FR     France
GA     The Gambia
GB     Gabon
GG     Georgia
GH     Ghana
GJ     Grenada
GM     Germany
GR     Greece
GT     Guatemala
GV     Guinea
GY     Guyana
HA     Haiti
HO     Honduras
HR     Croatia
HU     Hungary
IC     Iceland
ID     Indonesia
IN     India
IR     Iran
IS     Israel
IT     Italy
IV     C�te d'Ivoire
IZ     Iraq
JA     Japan
JM     Jamaica
JO     Jordan
KE     Kenya
KG     Kyrgyzstan
KN     North Korea
KR     Kiribati
KS     South Korea
KU     Kuwait
KZ     Kazakhstan
LA     Laos
LE     Lebanon
LG     Latvia
LH     Lithuania
LI     Liberia
LO     Slovakia
LS     Liechtenstein
LT     Lesotho
LU     Luxembourg
LY     Libya
MA     Madagascar
MD     Moldova
MG     Mongolia
MI     Malawi
MK     Macedonia
ML     Mali
MN     Monaco
MO     Morocco
MP     Mauritius
MR     Mauritania
MT     Malta
MU     Oman
MV     Maldives
MX     Mexico
MY     Malaysia
MZ     Mozambique
NG     Niger
NH     Vanuatu
NI     Nigeria
NL     Netherlands
NO     Norway
NP     Nepal
NR     Nauru
NS     Suriname
NU     Nicaragua
NZ     New Zealand
PA     Paraguay
PE     Peru
PK     Pakistan
PL     Poland
PM     Panama
PO     Portugal
PP     Papua New Guinea
PS     Palau
PU     Guinea-Bissau
QA     Qatar
RM     Marshall Islands
RO     Romania
RP     Philippines
RS     Russia
RW     Rwanda
SA     Saudi Arabia
SC     Saint Kitts and Nevis
SE     Seychelles
SF     South Africa
SG     Senegal
SI     Slovenia
SL     Sierra Leone
SM     San Marino
SN     Singapore
SO     Somalia
SP     Spain
ST     Saint Lucia
SU     Sudan
SW     Sweden
SY     Syria
SZ     Switzerland
TC     United Arab Emirates
TD     Trinidad and Tobago
TH     Thailand
TI     Tajikistan
TN     Tonga
TO     Togo
TP     Sao Tome and Principe
TS     Tunisia
TU     Turkey
TV     Tuvalu
TW     Taiwan
TX     Turkmenistan
TZ     Tanzania
UG     Uganda
UK     United Kingdom
UP     Ukraine
US     United States
UV     Burkina Faso
UY     Uruguay
UZ     Uzbekistan
VC     Saint Vincent and the Grenadines
VE     Venezuela
VM     Vietnam
VT     Holy See

 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 *
 */
public enum CountryCode {

    Namibia ("WA"),
    Samoa ("WS"),
    Swaziland ("WZ"),
    Yugoslavia ("YI"),
    Yemen ("YM"),
    Zambia ("ZA"),
    Zimbabwe ("ZI");

    private final String value;

    CountryCode (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
