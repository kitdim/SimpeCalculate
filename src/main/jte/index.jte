<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Обратная связь</title>
    <style>
        body {
          width: 100vw;
          height: 100vh;
          margin: 0;
          font: 18px/1.5 sans-serif;
          background-color: #0093e9;
          background-image: linear-gradient(160deg, #0093e9 0%, #80d0c7 100%);
        }
        .form {
          box-sizing: border-box;
          width: 500px;
          padding: 30px 80px;
          background: #fff;
          border-radius: 7px;
        }
        .form-input>* {
          display: block;
          width: 100%;
        }
        .form-input input,
        .form-input textarea {
          box-sizing: border-box;
          height: 50px;
          padding: 10px 20px;
          border: 1px solid #e2e2e2;
        }
        .form-input textarea {
          height: 200px;
          resize: none;
        }
        .btn {
          padding: 15px 30px;
          font-weight: bold;
          border: none;
          cursor: pointer;
        }
        .btn-green {
          color: #fff;
          background: #4caf50;
        }
        .block-center {
          position: absolute;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
        }
        .mb-1 {
          margin-bottom: 1em;
        }
        .mb-2 {
          margin-bottom: 1.5em;
        }
        .sr-only {
          position: absolute;
          width: 1px;
          height: 1px;
          padding: 0;
          overflow: hidden;
          white-space: nowrap;
          border: 0;
        }
    </style>
</head>
<body>
<form class="block-center form">
    <h1>Calculation</h1>
    <div class="form-input mb-2">
        <label for="message" class="sr-only">Your maths example.</label>
        <textarea id="message" placeholder="5+5"></textarea>
    </div>
    <button class="btn btn-green">Send</button>
</form>
</body>
</html>
