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
              <h2 id="FrmH2">My Fibank</h2>
              <br>
              <fieldset style="font-family: 'Trebuchet MS', arial, sans-serif;">
                <table style="width: 500px;">
                  <tbody><tr>
                    <td>
                      <div style="padding-left:15px; height:60px">
                        <label style="text-align:left;" id="l_username" for="UserField">User name:<input type="text" class="inputi" value="" name="fldUserId" id="UserField" autocomplete="off">
                          <span class="RequiredData" id="resUserField">&nbsp;</span>
                        </label>
                        <label style="text-align:left;" id="l_password" for="PasswordField">Password:<input type="password" class="inputi" value="" name="fldPassword" id="PasswordField" autocomplete="off">
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
                                  <a title="Регистрация на потребител" id="a_reg" target="_self" href="Registration">Registration</a>
                                </td>
                                <td style="padding-left:10px;">
                                  <a target="_self" href="../LostPassword" id="a_LostPswd">Password reset</a>
                                </td>
                              </tr>
                            </tbody></table>
                          </td>
                          <td>
                            <div style="height:28px; margin:10px 0; ">
                              <input type="submit" value="Login" class="button">
                             
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
        </div>
      </div>
    </div>