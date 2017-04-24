package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("  \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>Welcome to Spring Web MVC project</title>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("    <h1>Compra de Productos</h1>\r\n");
      out.write("    <form method=\"POST\" action=\"practica.usil\">\r\n");
      out.write("      <p>\r\n");
      out.write("        Nombre del Producto:\r\n");
      out.write("        <input type=\"text\" name=\"txtProducto\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        Tamaño de Lote\r\n");
      out.write("        <input type=\"text\" name=\"txtCant\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        Precio del Lote\r\n");
      out.write("        <input type=\"text\" name=\"txtPrecio\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        Gastos Administrativos\r\n");
      out.write("        <input type=\"text\" name=\"txtGastos\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p>\r\n");
      out.write("        Ganancia por Unidad\r\n");
      out.write("        <input type=\"text\" name=\"txtPreventa\">\r\n");
      out.write("      </p>\r\n");
      out.write("      <p><input type=\"submit\" value=\"Procesar\"></p>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("      <h1>Reporte</h1>\r\n");
        out.write("      <p>Unidades a comercializar: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Tamaño del Lote: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.cantidad}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Precio del Lote: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.costo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Gastos Administrativos: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.gastoporcentaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Ganancia por Unidad: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.ganancia}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Unidades a comercialixzar: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.tocantidad}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Costo total del lote: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.costotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Costo por unidad: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.costunid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("      <p>Precio de venta : ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vm.preventa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
