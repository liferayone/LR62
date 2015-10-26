/*
Created By Sachin For PRT-751 :Export corporate Calendar for outlook
*/
package com.twelve.capital.outlook.configure.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.util.CalendarDataFormat;
import com.liferay.calendar.util.CalendarDataHandler;
import com.liferay.calendar.util.CalendarDataHandlerFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.util.portlet.PortletProps;

public class OutlookExchangeCalendar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			long calendarId = GetterUtil.getLong(PortletProps
					.get("default.twelvecapital.calendarId"));
			// long calendarId = 11932;

			Calendar calendar = CalendarLocalServiceUtil
					.getCalendar(calendarId);

			String fileName = calendar.getName(LocaleUtil.US) + CharPool.PERIOD
					+ String.valueOf(CalendarDataFormat.ICAL);

			CalendarDataHandler calendarDataHandler = CalendarDataHandlerFactory
					.getCalendarDataHandler(CalendarDataFormat.ICAL);

			String data = calendarDataHandler.exportCalendar(calendarId);

			PrintWriter out = response.getWriter();
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ fileName + "\"");

			InputStream is = new ByteArrayInputStream(data.getBytes());

			int i;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			is.close();
			out.close();

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
