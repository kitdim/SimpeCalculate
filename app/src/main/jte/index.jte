@import org.kit.task.dto.BuildCalculatePage
@import org.kit.task.dto.CalculatePage
@import org.kit.task.util.NamedRoutes

@param BuildCalculatePage pageBuild
@param CalculatePage page


<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Calculate</title>
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
        .mb-2 {
          margin-bottom: 1.5em;
        }
    </style>
</head>
<body>
@if(pageBuild != null)
    <div class="mb-3">
        <ul>
            @for(var validator : pageBuild.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    </div>
@endif
<form class="block-center form" action="${NamedRoutes.main()}" method="post">
    <h1>Calculation</h1>
    <div class="form-input mb-2">
        @if(pageBuild == null)
            <input type="text" id="input" name="input" placeholder="...">
        @else
            <input type="text" id="input" name="input" placeholder="..." value="${pageBuild.getInput()}">
        @endif
    </div>
    <div class="form-input mb-2">
        @if(page != null)
            <p>Result: ${page.getResult()}</p>
        @else
            <p>Result: 0</p>
        @endif
    </div>
    <input class="btn btn-green" type="submit" value="Enter"/>
</form>
</body>
</html>
