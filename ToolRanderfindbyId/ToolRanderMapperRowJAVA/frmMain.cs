﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using Microsoft.WindowsAPICodePack.Shell;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;
using System.Text.RegularExpressions;

namespace ToolRanderMapperRowJAVA
{
    public partial class frmMain : Form
    {
        private string pathCommon = string.Empty;
        public frmMain()
        {
            InitializeComponent();
        }
        private void frmMain_Load(object sender, EventArgs e)
        {
            ShowLayout(false);
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            ClearText();
            ShowLayout(false);
        }

        private void btnRender_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(txtContent.Text.Trim().ToString()))
            {
                MessageBox.Show("Thông tin nhập vào chưa đầy đủ");
            }
            else
            {
                RenderContent(txtContent.Text.Trim());
                MessageBox.Show("Successfully", " Messagebox", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private void RenderContent(string text)
        {
            try
            {
                DateTime localDate = DateTime.Now;
                string nameFile = @"\" + localDate.ToString("ddMMyyyy") + ".txt";
                string path = KnownFolders.Downloads.Path + nameFile;

                // Check if file already exists. If yes, delete it.     
                if (File.Exists(path))
                {
                    File.Delete(path);
                }

                List<string> results = new List<string>();

                string[] listContent = text.Split(';');
                foreach (string item in listContent)
                {
                    if (!string.IsNullOrEmpty(item))
                    {
                        string content = Regex.Replace(item.Trim(), @"\t|\n|\r", "");
                        string type = content.Substring(0, content.IndexOf(" ")).Trim();
                        string name = content.Substring(content.LastIndexOf(" "), content.Length - content.LastIndexOf(" ")).Trim();
                        string textResult = name + "= (" + type + ")" + "findViewById(R.id."+ name +");";

                        results.Add(textResult);
                    }
                }
                System.IO.File.WriteAllLines(path, results);
                txtPath.Text = pathCommon = path;
                ShowLayout(true);
            }
            catch
            {
                MessageBox.Show("Error create content", " Messagebox", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void txtContent_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((int)e.KeyChar > 127)
                e.Handled = true;
        }

        private void ClearText()
        {
            txtContent.Text = txtResult.Text = txtValue.Text = txtPath.Text = "";
        }

        private void btnShow_Click(object sender, EventArgs e)
        {
            Process.Start("notepad.exe", pathCommon);
        }

        private void ShowLayout(bool status)
        {
            btnShow.Enabled = status;
        }


    }
}
