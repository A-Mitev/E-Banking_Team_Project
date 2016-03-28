<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="stylesheet" href="loginForm.css" />
<div style="min-height:650px;text-align:center;" class="fluid" id="body">
      <div class="containercenter">
        <div id="logincontent">
          <div id="loginform">
            <form action="Logon" method="post" id="frmLogon" name="frmLogon">
              <h2 id="FrmH2">Моята Fibank</h2>
              <br>
              <fieldset style="font-family: 'Trebuchet MS', arial, sans-serif;">
                <table style="width: 500px;">
                  <tbody><tr>
                    <td>
                      <div style="padding-left:15px; height:60px">
                        <label style="text-align:left;" id="l_username" for="UserField">Потребителско име:<input type="text" class="inputi" value="" name="fldUserId" id="UserField" autocomplete="off">
                          <span class="RequiredData" id="resUserField">&nbsp;</span>
                        </label>
                        <label style="text-align:left;" id="l_password" for="PasswordField">Парола:<input type="password" class="inputi" value="" name="fldPassword" id="PasswordField" autocomplete="off">
                          <span class="RequiredData" id="resPasswordField">&nbsp;</span>
                        </label>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td align="left">
                      <table bgcolor="white" width="100%">
                        <tbody><tr>
                          <td style="vertical-align:middle; width:80% ">
                            <table style="font-size: 12px; margin-left:35px">
                              <tbody><tr>
                                <td>
                                  <a title="Регистрация на потребител" id="a_reg" target="_self" href="Registration">Регистрация</a>
                                </td>
                                <td style="padding-left:10px;">
                                  <a target="_self" href="../LostPassword" id="a_LostPswd">Забравена парола</a>
                                </td>
                              </tr>
                            </tbody></table>
                          </td>
                          <td>
                            <div style="height:28px; margin:10px 0; ">
                              <input type="submit" value="Вход" class="button">
                              </a>
                            </div>
                          </td>
                        </tr>
                      </tbody></table>
                    </td>
                  </tr>
                </tbody></table>
              </fieldset>
              <input type="hidden" value="Login" name="LoginType" id="LoginType">
              <input type="hidden" value="bg" name="Lang" id="Lang">
            </form>
          </div>
          <div style="width:100%;" id="SSLInfo">
            <table cellspacing="0" cellpadding="1" border="0" align="center" width="80" title="Чрез &quot;кликване&quot; можете да се уверите, че този сайт е избрал Thawte SSL за сигурност при електронна търговия и поверителни комуникации." id="table_thawte" style="margin:0 auto;">
              <tbody><tr>
                <td align="center" width="80" valign="top">
                  <script src="https://seal.thawte.com/getthawteseal?host_name=my.fibank.bg&amp;size=S&amp;lang=en" type="text/javascript">&nbsp;</script><a target="THAWTE_Splash" onmousedown="return v_mDown(event);" tabindex="-1" href="https://sealinfo.thawte.com/thawtesplash?form_file=fdf/thawtesplash.fdf&amp;dn=MY.FIBANK.BG&amp;lang=en"><img border="true" alt="Click to Verify - This site has chosen a thawte SSL Certificate to improve Web site security" oncontextmenu="return false;" src="https://seal.thawte.com/getthawteseal?at=0&amp;sealid=2&amp;dn=MY.FIBANK.BG&amp;lang=en&amp;gmtoff=-180" name="seal"></a>
                </td>
              </tr>
              <tr>
                <td align="center" valign="top">
                  <a style="color:#333; text-decoration:none; font:#030303 10px arial,sans-serif; text-align:center; margin:0px; padding:0px;" target="_blank" href="http://www.thawte.com/digital-certificates/" id="a_thawte" title="Информация за SSL сертификатите">За SSL сертификатите</a>
                </td>
                <td width="155">&nbsp;</td>
              </tr>
            </tbody></table>
          </div>
          <div xmlns="" style="text-align:left" id="divwarning">
          <br>
          Уважаеми клиенти,<br><br> Присъединете се към инициативата на Fibank към опазване и спестяване на ограничените природни ресурси. <br><br>
          Предлагаме Ви да се регистрирате за безплатните електронни извлечения по кредитни карти, предоставени чрез услугата "Моята Fibank", при което автоматично ще преустановим изпращането на хартиени извлечения. <br><br>
          За повече информация: 0700 12 777 или на адрес: <a href="mailto: my.fibank@fibank.bg">my.fibank@fibank.bg</a>
          <br><br>Разговорите към национален номер 0700 12 777 се таксуват според определените от Вашия оператор цени за обаждане към номера тип 0700 на Vivacom.<br> За абонати на Vivacom обаждане към този номер се таксува като обаждане към стационарен номер в мрежата на Vivacom.

          <br></div>
          <div xmlns="" style="text-align:left" id="message">
          ВАЖНО ! <br>ПИБ АД УВЕДОМЯВА КАРТОДЪРЖАТЕЛИТЕ си,  че има информация за получени фалшиви съобщения по електронната поща, които претендират да са изпратени от БОРИКА. С тях се изискват данни на картодържатели, включващи:  име на картодържателя, ПИН код, ЕГН, номер на карта и други лични данни, свързани с картодържателя и картата.
          <br>Напомняме ви, че банката-издател или БОРИКА по никакъв повод не изискват такива данни. Предупреждаваме картодържателите да не предоставят информация за картите си при никакви обстоятелства, дори ако данните се изискват чрез Интернет сайт, който съдържа логото или наподобява оригиналния сайт на банката или БОРИКА.<br>
          <br></div>
        </div>
      </div>
    </div>